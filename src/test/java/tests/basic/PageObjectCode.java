package tests.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.usual_pages.MessagesPage;
import tests.supers.TestBase;
import util.GenUtils;


public class PageObjectCode extends TestBase {

	private String siteName="https://www.automationexercise.com/";
	private String timestamp;
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String state;
	private String country;
	private String city;
	private String address;
	private String company;
	private String phoneNumber;
	private String zipCode;
	private String day;
	private String month;
	private String year;

	@Test
	public void test() {
		try {

			initParameters();

			WebDriver driver = app.getDriver();

			log.info("Opening site '"+siteName+"'...");
			driver.get(siteName);

			app.pages().homePage.ensurePageLoaded()
					.clickSignupLoginLink()

					.typeUsername(username)
					.typeSignupEmail(email)
					.clickSignupBtn()

					.typeTitle()
					.typePassword(password)
					.markDayOfBirth(day)
					.markMonthOfBirth(month)
					.markYearOfBirth(year)
					.typeNewsletter()
					.typeOffers()
					.typeFirstName(firstName)
					.typeLastName(lastName)
					.typeCompany(company)
					.typeAddress1(address)
					.typeState(state)
					.typeCountry(country)
					.typeCity(city)
					.typeZipCode(zipCode)
					.typePhoneNumber(phoneNumber)
					.clickCreateAccountButton()
					.verifyMessageText(MessagesPage.MessagesList.ACCOUNT_CREATED)

					.clickContinue()

					.verifyLogoutLink()
					.clickDeleteAccountLink()

					.verifyMessageText(MessagesPage.MessagesList.ACCOUNT_DELETED)
					.clickContinue()

					.findSignupLoginLink();

			GenUtils.sleepMillis(1000);
			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameters() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		username = "Tomer";
		email = "Tomeravr@edu.hac.ac.il";
		password = "123456";
		firstName = "Tomer";
		lastName = "Avrahami";
		address = "Oskar 12";
		state = "Israel";
		country = "Israel";
		city = "Jerusalem";
		phoneNumber = "0524858334";
		company = "Ness";
		zipCode = "123987";
		day = "15";
		month = "2";
		year = "1999";
	}
}