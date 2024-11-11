package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.InventoryPage;
import pages.LoginPage;

public class BrowserSpecificBasicTest {
    protected String url = "https://www.saucedemo.com/";
    protected static WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    protected static final Logger logger = LoggerFactory.getLogger(BrowserSpecificBasicTest.class);

    protected void setUpDriver(String browserType) {
        if (browserType == null) {
            throw new IllegalArgumentException("Browser type cannot be null");
        }

        switch (browserType.toUpperCase()) {
            case "CHROME":
                logger.info("Setting up the ChromeDriver for the tests.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                logger.info("Setting up the FirefoxDriver for the tests.");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                logger.info("Setting up the EdgeDriver for the tests.");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void clearCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            logger.info("Closing the current browser window.");
            driver.close();
        }
    }
}
