package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class RegisterPage extends MenusPage{

	public RegisterPage(MainPageManager pages) {
		super(pages);
	}

	public RegisterPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Verify that the registration page has opened successfully");
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qa='create-account']")));
		return this;
	}

	public RegisterPage typeTitle(){
		log.info("Fill title as Mr.");
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
		return this;
	}

	public RegisterPage typePassword(String password){
		log.info("Fill password: '"+ password + "'");
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		return this;
	}

	public RegisterPage typeNewsletter(){
		log.info("Tick 'Sign up for our newsletter!'");
		driver.findElement(By.cssSelector("input#newsletter")).click();
		return this;
	}

	public RegisterPage typeOffers(){
		log.info("Tick 'Receive special offers from our'");
		driver.findElement(By.cssSelector("input#optin")).click();
		return this;
	}

	public RegisterPage typeFirstName(String firstName){
		log.info("Fill '" + firstName + "' in first name");
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		return this;
	}

	public RegisterPage typeLastName(String lastName){
		log.info("Fill '" + lastName + "' in last name");
		driver.findElement(By.name("first_name")).sendKeys(lastName);
		return this;
	}

	public RegisterPage typeCompany(String company){
		log.info("Fill '" + company +"' as company");
		driver.findElement(By.cssSelector("input#company")).sendKeys(company);
		return this;
	}

	public RegisterPage typeAddress1(String address){
		log.info("Fill '" +address +"' in address");
		driver.findElement(By.id("address1")).sendKeys(address);
		return this;
	}

	public RegisterPage typeCountry(String country){
		log.info("Select '"+ country +"' as Country"); //
		new Select(driver.findElement(By.id("country"))).selectByValue(country);
		return this;
	}

	public RegisterPage typeState(String state){
		log.info("fill '"+ state +"' as State");
		driver.findElement(By.id("state")).sendKeys(state);
		return this;
	}

	public RegisterPage typeCity(String city){
		log.info("Fill '"+ city +"' as City");
		driver.findElement(By.id("city")).sendKeys(city);
		return this;
	}

	public RegisterPage typeZipCode(String zipCode){
		log.info("Fill '"+zipCode+"' as Zipcode");
		driver.findElement(By.id("zipcode")).sendKeys(zipCode);
		return this;
	}

	public RegisterPage typePhoneNumber(String phoneNumber){
		log.info("Fill ' "+phoneNumber +"' as Mobile Number");
		driver.findElement(By.id("mobile_number")).sendKeys(phoneNumber);
		return this;
	}

	public MessagesPage clickCreateAccountButton(){
		log.info("Click Create Account");
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).submit();
		return pages.messagesPage.ensurePageLoaded();
	}

	public RegisterPage markDayOfBirth(String day){
		log.info("filled day of birth'");
		new Select(driver.findElement(By.id("days"))).selectByValue(day);
		return this;
	}

	public RegisterPage markMonthOfBirth(String month){
		log.info("filled month of birth'");
		new Select(driver.findElement(By.id("months"))).selectByValue(month);
		return this;
	}

	public RegisterPage markYearOfBirth(String year){
		log.info("filled year of birth'");
		new Select(driver.findElement(By.id("years"))).selectByValue(year);
		return this;
	}

}
