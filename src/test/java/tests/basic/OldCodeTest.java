package tests.basic;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {

	String timestamp, email, password, username, firstName, lastName, address, state, city, phoneNumber, company, zipCode,day,month,year;
	private final static String SITE_NAME ="https://www.automationexercise.com/";
	final static String ACCOUNT_DELETED_MSG = "ACCOUNT DELETED!";
	final static String ACCOUNT_CREATED_MSG = "ACCOUNT CREATED!";

	@Test
	public void test() {
		try {

			initParameter();

			WebDriver driver = app.getDriver();

			log.info("Opening site '"+ SITE_NAME +"'...");
			driver.get(SITE_NAME);

			log.info("Verify that the website has opened successfully");
			driver.findElement(By.className("brands_products"));
			log.info("The website has opened successfully.");

			log.info("Click 'Sign Up / Login' link");
			driver.findElement(By.linkText("Signup / Login")).click();

			log.info("Verify that the Sign up / Login page has opened successfully");
			driver.findElement(By.className("signup-form"));
			log.info("Sign up page has opened successfully.");

			log.info("Fill '" + username + "'in the New user Signup Name box");
			driver.findElement(By.name("name")).sendKeys(username);

			log.info("Enter Email address: " + email);
			driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(email);

			log.info("Click the 'signup' button");
			driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

			log.info("Verify that the Sign up page has opened successfully");
			driver.findElement(By.cssSelector("button[data-qa='create-account']"));
			log.info("Sign up page has opened successfully.");

			log.info("Fill title as Mr.");
			driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();

			log.info("Fill password: '"+ password + "'");
			driver.findElement(By.cssSelector("input#password")).sendKeys(password);

			log.info("Fill DoB: 15 fabruary 1999");

            // Fill DoB: 15 February 1999 using Select
			log.info("filled day of birth'");
			new Select(driver.findElement(By.id("days"))).selectByValue(day);

			log.info("filled month of birth'");
			new Select(driver.findElement(By.id("months"))).selectByValue(month);

			log.info("filled year of birth'");
			new Select(driver.findElement(By.id("years"))).selectByValue(year);

			log.info("Tick 'Sign up for our newsletter!'");
			driver.findElement(By.cssSelector("input#newsletter")).click();

			log.info("Tick 'Receive special offers from our'");
			driver.findElement(By.cssSelector("input#optin")).click();

			log.info("Fill '" + firstName + "' in first name");
			driver.findElement(By.name("first_name")).sendKeys(firstName);

			log.info("Fill '" + lastName +"' in last name");
			driver.findElement(By.name("last_name")).sendKeys(lastName);

			log.info("Fill '" + company +"' as company");
			driver.findElement(By.cssSelector("input#company")).sendKeys(company);

			log.info("Fill '" +address +"' in address");
			driver.findElement(By.id("address1")).sendKeys(address);

			log.info("Select '"+ state +"' as Country");
			new Select(driver.findElement(By.id("country"))).selectByVisibleText(state);

			log.info("Select '"+ state +"' as State");
			driver.findElement(By.id("state")).sendKeys(state);

			log.info("Fill '"+ city +"' as City");
			driver.findElement(By.id("city")).sendKeys(city);

			log.info("Fill '"+zipCode+"' as Zipcode");
			driver.findElement(By.id("zipcode")).sendKeys(zipCode);

			log.info("Fill ' "+phoneNumber +"' as Mobile Number");
			driver.findElement(By.id("mobile_number")).sendKeys(phoneNumber);

			log.info("Click Create Account");
			driver.findElement(By.cssSelector("button[data-qa='create-account']")).submit();

			//fixed the mistake in my homework:
			log.info("Verify that account created successfully");
			String actualCreateString = driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText();
			Assert.assertTrue(actualCreateString.equals(ACCOUNT_CREATED_MSG),
					"Expected value: '" + ACCOUNT_CREATED_MSG + "', but actual is '" + actualCreateString + "'");
			log.info("Account has been successfully created");

			log.info("Click continue");
			driver.findElement(By.xpath("//*[@id=\"form\"]//a")).click();

			log.info("Verify that we went back to main page");
			driver.findElement(By.className("brands_products"));
			log.info("The main page has opened successfully.");

			log.info("Click 'Delete Account' link");
			driver.findElement(By.xpath("//*[@id=\"header\"]//ul/li[5]/a")).click();

			log.info("Verify that we got to 'Account Deleted' page");
			String actualDeleteString = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']")).getText();
			Assert.assertTrue(actualDeleteString.equals(ACCOUNT_DELETED_MSG),
					"Expected value: '" + ACCOUNT_DELETED_MSG + "', but actual is '" + actualDeleteString + "'");
			log.info("Account has been successfully deleted");

			log.info("Click 'Continue' button");
			driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

			log.info("Verify that we went back to main page (After account deletion)");
			driver.findElement(By.className("brands_products"));
			log.info("The main page has opened successfully.");

			log.info("Find 'Sign Up / Login' link");
			driver.findElement(By.linkText("Signup / Login"));

			GenUtils.sleepMillis(2000);

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameter() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		username = "Tomer";
		email = "Tomeravr@edu.hac.ac.il";
		password = "123456";
		firstName = "Tomer";
		lastName = "Avrahami";
		address = "Oskar 12";
		state = "Israel";
		city = "Jerusalem";
		phoneNumber = "0524858334";
		company = "Ness";
		zipCode = "123987";
		day = "15";
		month = "2";
		year = "1999";
	}
}
