package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.supers.TestBase;

public class AppiumTestExample extends TestBase {

	@Test
	public void test() {
		try {

			WebDriver driver = app.getDriver();
			log.info("Click Delete");
			driver.findElement(By.id("com.google.android.calculator:id/del")).click();

			log.info("Click 2");
			driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();

			log.info("Click +");
			driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();

			log.info("Click 5");
			driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();

			log.info("Click =");
			driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();

			log.info("Get result...");
			String result = driver.findElement(By.className("android.widget.TextView")).getText();
			log.info("Result is : " + result);

			log.info("Rotate Landscape");
			((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
			log.info("Rotate Portrait");
			((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);


			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
}
