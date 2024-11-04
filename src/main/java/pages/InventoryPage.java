package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage {

    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getInventoryPageTitle() {
        return driver.getTitle();
    }
}
