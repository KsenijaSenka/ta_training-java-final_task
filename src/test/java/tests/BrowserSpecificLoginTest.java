package tests;

import enums.BrowserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrowserSpecificLoginTest extends BrowserSpecificBasicTest{
    @DisplayName("UC-1: Verify Unsuccessful Login with Empty Credentials - Chrome")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyCredentialsChrome() {
        setUpDriver("CHROME");
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty credentials test on Chrome.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsernameInput(BrowserType.CHROME);
        loginPage.clearPasswordInput(BrowserType.CHROME);

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Username is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
            logger.info("Test passed for Chrome, error message \"Username is required\" is found.");
        } else {
            logger.error("Test failed for Chrome, error message \"Username is required\" is not found.");
        }
    }

    @DisplayName("UC-1: Verify Unsuccessful Login with Empty Credentials - Edge")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyCredentialsEdge() {
        setUpDriver("EDGE");
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty credentials test on Edge.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsernameInput(BrowserType.EDGE);
        loginPage.clearPasswordInput(BrowserType.EDGE);

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Username is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
            logger.info("Test passed for Edge, error message \"Username is required\" is found.");
        } else {
            logger.error("Test failed for Edge, error message \"Username is required\" is not found.");
        }
    }

    @DisplayName("UC-1: Verify Unsuccessful Login with Empty Credentials - Firefox")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyCredentialsFirefox() {
        setUpDriver("FIREFOX");
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty credentials test on Firefox.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsernameInput(BrowserType.FIREFOX);
        loginPage.clearPasswordInput(BrowserType.FIREFOX);

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Username is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
            logger.info("Test passed for Firefox, error message \"Username is required\" is found.");
        } else {
            logger.error("Test failed for Firefox, error message \"Username is required\" is not found.");
        }
    }
    @DisplayName("UC-2: Verify Unsuccessful Login with Empty Password - Chrome")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyPasswordChrome() {
        setUpDriver("CHROME");  // Set Firefox for this test
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty password test on Chrome.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPasswordInput(BrowserType.CHROME);

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Password is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
            logger.info("Test passed for Chrome, error message \"Password is required\" is found.");
        } else {
            logger.error("Test failed for Chrome, error message \"Password is required\" is not found.");
        }
    }

    @DisplayName("UC-2: Verify Unsuccessful Login with Empty Password - Edge")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyPasswordEdge() {
        setUpDriver("EDGE");  // Set Firefox for this test
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty password test on Edge.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPasswordInput(BrowserType.EDGE);

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Password is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
            logger.info("Test passed for Edge, error message \"Password is required\" is found.");
        } else {
            logger.error("Test failed for Edge, error message \"Password is required\" is not found.");
        }
    }

    @DisplayName("UC-2: Verify Unsuccessful Login with Empty Password - Firefox")
    @Test
    public void verifyUnsuccessfulLoginWithEmptyPasswordFirefox() {
        setUpDriver("FIREFOX");  // Set Firefox for this test
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty password test on Firefox.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPasswordInput(BrowserType.FIREFOX);  // Using the corresponding browser type

        loginPage.clickOnLoginButton();

        wait.withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(loginPage.getErrorMessageElement(), "Password is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
            logger.info("Test passed for Firefox, error message \"Password is required\" is found.");
        } else {
            logger.error("Test failed for Firefox, error message \"Password is required\" is not found.");
        }
    }

    @DisplayName("UC-3: Test Login form with credentials by passing Username & Password - Chrome")
    @Test
    public void verifySuccessfulLoginChrome() {
        setUpDriver("CHROME");
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login test on Chrome with username: " + username);

        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertThat("Expected page title is 'Swag Labs'.",
                inventoryPage.getInventoryPageTitle(), equalTo("Swag Labs"));

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for Chrome, the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for Chrome, the title \"Swag Labs\" is not found.");
        }
    }
    @DisplayName("UC-3: Test Login form with credentials by passing Username & Password - Firefox")
    @Test
    public void verifySuccessfulLoginFirefox() {
        setUpDriver("FIREFOX");
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login test on Firefox with username: " + username);

        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertThat("Expected page title is 'Swag Labs'.",
                inventoryPage.getInventoryPageTitle(), equalTo("Swag Labs"));

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for Firefox, the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for Firefox, the title \"Swag Labs\" is not found.");
        }
    }

    @DisplayName("UC-3: Test Login form with credentials by passing Username & Password - Edge")
    @Test
    public void verifySuccessfulLoginEdge() {
        setUpDriver("EDGE");
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login test on Edge with username: " + username);

        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertThat("Expected page title is 'Swag Labs'.",
                inventoryPage.getInventoryPageTitle(), equalTo("Swag Labs"));

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for Edge, the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for Edge, the title \"Swag Labs\" is not found.");
        }
    }
}
