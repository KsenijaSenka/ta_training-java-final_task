import enums.BrowserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BasicTest {

    @DisplayName("UC-1: Verify Unsuccessful Login with Empty Credentials")
    @ParameterizedTest
    @EnumSource(BrowserType.class)
    @Order(1)
    @Tag("nonParallel")
    public void verifyUnsuccessfulLoginWithEmptyCredentials(BrowserType browserType) {
        setUpDriver(browserType);
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty credentials test.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsernameInput(browserType);
        loginPage.clearPasswordInput(browserType);

        loginPage.clickOnLoginButton();

        wait
                .withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Username is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
            logger.info("Test passed for " + browserType + ", error message \"Username is required\" is found.");
        } else {
            logger.error("Test failed for " + browserType + ", error message \"Username is required\" is not found.");
        }
    }

    @DisplayName("UC-2: Verify Unsuccessful Login with Empty Password")
    @ParameterizedTest
    @EnumSource(BrowserType.class)
    @Tag("nonParallel")
    @Order(2)
    public void verifyUnsuccessfulLoginWithEmptyPassword(BrowserType browserType) {
        setUpDriver(browserType);
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty password test.");

        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPasswordInput(browserType);

        loginPage.clickOnLoginButton();

        wait
                .withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Password is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
            logger.info("Test passed for " + browserType + ", error message \"Password is required\" is found.");
        } else {
            logger.error("Test failed for " + browserType + ", error message \"Password is required\" is not found.");
        }
    }

    @DisplayName("UC-3: Test Login form with credentials by passing Username & Password")
    @ParameterizedTest
    @EnumSource(BrowserType.class)
    public void verifySuccessfulLogin(BrowserType browserType) {
        setUpDriver(browserType);
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login with valid credentials test for Chrome.");

        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
                "The page title should be 'Swag Labs'.");

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for " + browserType + ", the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for " + browserType + ", the title \"Swag Labs\" is not found.");
        }
    }
}
