package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class LoginOrSignupPage extends MenusPage{

    public LoginOrSignupPage(MainPageManager pages){
        super(pages);
    }

    public LoginOrSignupPage ensurePageLoaded(){
        super.ensurePageLoaded();
        log.info("Verify that the Sign up / Login page has opened successfully");
        waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Signup / Login"))));
        return this;
    }

    public LoginOrSignupPage typeUsername(String username){
        log.info("Fill '" + username + "'in the New user Signup Name box");
        driver.findElement(By.name("name")).sendKeys(username);
        return this;
    }

    public LoginOrSignupPage typeSignupEmail(String email){
        log.info("Enter Email address: " + email);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(email);
        return this;
    }

    public RegisterPage clickSignupBtn(){
        log.info("Click the 'signup' button");
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        return pages.registerPage.ensurePageLoaded();
    }

}
