package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class MessagesPage extends MenusPage {


    public MessagesPage(MainPageManager pages){
        super(pages);
    }

    public MessagesPage ensurePageLoaded(){
        super.ensurePageLoaded();
        waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Continue"))));
        return this;
    }


    public enum MessagesList {
        ACCOUNT_CREATED {
            public String toString() {
                return "ACCOUNT CREATED!";
            }
        },
        ACCOUNT_DELETED {
            public String toString() {
                return "ACCOUNT DELETED!";
            }
        }
    }

    public MessagesPage verifyMessageText(MessagesList expectedMessage) {
        log.info("Ensure that '" + expectedMessage + "' message appears");

        String actualTextRegistration = driver.findElement(By.cssSelector(".title > b")).getText();

        Assert.assertEquals(
                expectedMessage.toString(),
                actualTextRegistration,
                "Expected value: '" + expectedMessage + "', but actual is '" + actualTextRegistration + "'"
        );

        return this;
    }


    public MessagesPage verifyAccountCreatedPage(String ACCOUNT_CREATED_MSG){
        log.info("Verify that account created successfully");
        String actualCreateString = driver.findElement(By.cssSelector("h2[data-qa='account-created']")).getText();
        Assert.assertTrue(actualCreateString.equals(ACCOUNT_CREATED_MSG),
                "Expected value: '" + ACCOUNT_CREATED_MSG + "', but actual is '" + actualCreateString + "'");
        return this;
    }

    public MessagesPage verifyAccountDeletedPage(String ACCOUNT_DELETED_MSG){
        log.info("Verify that we got to 'Account Deleted' page");
        String actualDeleteString = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']")).getText();
        Assert.assertEquals(actualDeleteString, ACCOUNT_DELETED_MSG, "Expected value: '" + ACCOUNT_DELETED_MSG + "', but actual is '" + actualDeleteString + "'");
        return this;
    }

    public HomePage clickContinue(){
        log.info("Click 'Continue' button");
        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();

        return pages.homePage.ensurePageLoaded();
    }

}
