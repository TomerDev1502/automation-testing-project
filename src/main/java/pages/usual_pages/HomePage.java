package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class HomePage extends MenusPage {

    public HomePage(MainPageManager pages) {
        super(pages);
    }

    public HomePage ensurePageLoaded() {
        super.ensurePageLoaded();
        log.info("Ensure the Home page was opened...");
        waitBig.until(ExpectedConditions.presenceOfElementLocated(By.className("features_items")));
        return this;
    }

}
