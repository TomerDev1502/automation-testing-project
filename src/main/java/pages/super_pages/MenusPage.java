package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.usual_pages.MessagesPage;
import pages.usual_pages.LoginOrSignupPage;

public class MenusPage extends AnyPage{

	public MenusPage(MainPageManager pages) {
		super(pages);
	}

	public MenusPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}

	public LoginOrSignupPage clickSignupLoginLink(){
		log.info("Click 'Signup/Login' link");
		driver.findElement(By.linkText("Signup / Login")).click();
		return pages.loginOrSignupPage.ensurePageLoaded();
	}

	public MenusPage verifyLogoutLink(){
		log.info("Ensure 'Logout' link appears above'");
		driver.findElement(By.cssSelector("a[href='/logout']"));
		return this;
	}

	public MessagesPage clickDeleteAccountLink(){
		log.info("Click 'Delete Account' link");
		driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
		return pages.messagesPage.ensurePageLoaded();
	}

	public MenusPage findSignupLoginLink(){
		log.info("Find 'Sign Up / Login' link");
		driver.findElement(By.linkText("Signup / Login"));
		return this;
	}

}
