import enums.BrowserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InventoryPage;
import pages.LoginPage;
import utils.CsvAndEnumProvider;

import java.time.Duration;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BasicTest {

    @DisplayName("UC-1: Verify Unsuccessful Login with Empty Credentials")
    @ParameterizedTest
    @EnumSource(BrowserType.class)
    public void verifyUnsuccessfulLoginWithEmptyCredentials(BrowserType browserType) {
        setUpDriver(browserType);

        // Given: The login page is open, and the user has empty credentials
        logger.info("Starting the login test with empty credentials for " + browserType);
        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername("random_user");
        loginPage.enterPassword("random");

        loginPage.clearUsernameInput(browserType);
        loginPage.clearPasswordInput(browserType);

        // When: The user attempts to log in with empty credentials
        loginPage.clickOnLoginButton();

        // Then: The error message for a missing username should be displayed
        wait.withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Username is required"));

        assertThat("Expected error message is 'Username is required'.",
                loginPage.getErrorMessageElement().getText(), containsString("Username is required"));

//        setUpDriver(browserType);
//        String username = "random_user";
//        String password = "random";
//
//        logger.info("Starting the login with empty credentials test.");
//
//        driver.navigate().to(url);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        loginPage = new LoginPage(driver, wait);
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clearUsernameInput(browserType);
//        loginPage.clearPasswordInput(browserType);
//
//        loginPage.clickOnLoginButton();
//
//        wait
//                .withMessage("Error message for missing username should be present")
//                .until(ExpectedConditions.textToBePresentInElement(
//                        loginPage.getErrorMessageElement(), "Username is required"));
//
//        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
//            logger.info("Test passed for " + browserType + ", error message \"Username is required\" is found.");
//        } else {
//            logger.error("Test failed for " + browserType + ", error message \"Username is required\" is not found.");
//        }
    }

    @DisplayName("UC-2: Verify Unsuccessful Login with Empty Password")
    @ParameterizedTest
    @EnumSource(BrowserType.class)
    public void verifyUnsuccessfulLoginWithEmptyPassword(BrowserType browserType) {
        setUpDriver(browserType);

        // Given: The login page is open, and the user has provided only the username
        logger.info("Starting the login test with empty password for " + browserType);
        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername("random_user");

        loginPage.clearPasswordInput(browserType);

        // When: The user attempts to log in without a password
        loginPage.clickOnLoginButton();

        // Then: The error message for a missing password should be displayed
        wait.withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Password is required"));

        assertThat("Expected error message is 'Password is required'.",
                loginPage.getErrorMessageElement().getText(), containsString("Password is required"));
    }
//        setUpDriver(browserType);
//        String username = "random_user";
//        String password = "random";
//
//        logger.info("Starting the login with empty password test.");
//
//        driver.navigate().to(url);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        loginPage = new LoginPage(driver, wait);
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clearPasswordInput(browserType);
//
//        loginPage.clickOnLoginButton();
//
//        wait
//                .withMessage("Error message for missing password should be present")
//                .until(ExpectedConditions.textToBePresentInElement(
//                        loginPage.getErrorMessageElement(), "Password is required"));
//
//        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
//            logger.info("Test passed for " + browserType + ", error message \"Password is required\" is found.");
//        } else {
//            logger.error("Test failed for " + browserType + ", error message \"Password is required\" is not found.");



    @DisplayName("UC-3: Test Login form with credentials by passing Username & Password")
    @ParameterizedTest
    @ArgumentsSource(CsvAndEnumProvider.class)
    public void verifySuccessfulLogin(String username, String password, BrowserType browserType) {
        setUpDriver(browserType);

        // Given: The login page is open, and valid credentials are provided
        logger.info("Starting successful login test for " + browserType + " with username: " + username);
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        // When: The user logs in with valid credentials
        loginPage.clickOnLoginButton();

        // Then: The user should be redirected to the inventory page, with the title "Swag Labs"
        inventoryPage = new InventoryPage(driver, wait);
        assertThat("Expected page title is 'Swag Labs'.",
                inventoryPage.getInventoryPageTitle(), equalTo("Swag Labs"));
//        setUpDriver(browserType);
//
//        logger.info("Starting the login test for " + browserType + " with username: " + username);
//
//        driver.navigate().to(url);
//        loginPage = new LoginPage(driver, wait);
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickOnLoginButton();
//
//        inventoryPage = new InventoryPage(driver, wait);
//
////        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
////                "The page title should be 'Swag Labs'.");
//        assertThat("The page title should be 'Swag Labs'.", inventoryPage.getInventoryPageTitle(), equalTo("Swag Labs"));
//
//        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
//            logger.info("Test passed for " + browserType + ", the title \"Swag Labs\" is found.");
//        } else {
//            logger.error("Test failed for " + browserType + ", the title \"Swag Labs\" is not found.");
//        }
    }
}
