import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BasicTest {

    @Test
    @Tag("nonParallel")
    @Order(3)
    public void verifySuccessfulLoginWithChrome() {
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login with valid credentials test for Chrome.");
        setUpChrome();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
                "The page title should be 'Swag Labs'.");

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for Chrome, the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for Chrome, the title \"Swag Labs\" is not found.");
        }
    }

    @Test
    public void verifySuccessfulLoginWithEdge() {
        String username = "standard_user";
        String password = "secret_sauce";

        logger.info("Starting the login with valid credentials test for Edge.");
        setUpEdge();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
                "The page title should be 'Swag Labs'.");

        if (inventoryPage.getInventoryPageTitle().contains("Swag Labs")) {
            logger.info("Test passed for Edge, the title \"Swag Labs\" is found.");
        } else {
            logger.error("Test failed for Edge, the title \"Swag Labs\" is not found.");
        }
    }

    //    @Test
//    public void verifySuccessfulLoginWithMozilla() {
//        String username = "standard_user";
//        String password = "secret_sauce";
//
//        setUpFirefox();
//        driver.navigate().to(url);
//        loginPage = new LoginPage(driver, wait);
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickOnLoginButton();
//    }
    @Test
    @Order(1)
    @Tag("nonParallel")
    public void verifyUnsuccessfulLoginWithEmptyCredentials() {
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty credentials test.");
        setUpChrome();
        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsernameInput(loginPage.getUsernameInput());
        loginPage.clearPasswordInput(loginPage.getPasswordInput());

        loginPage.clickOnLoginButton();

        wait
                .withMessage("Error message for missing username should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Username is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Username is required")) {
            logger.info("Test passed, error message \"Username is required\" is found.");
        } else {
            logger.error("Test failed, error message \"Username is required\" is not found.");
        }
    }

    //    assertTrue(
//            loginPage.getErrorMessageElement().contains("Username is required"),
//            "Error message for missing username should be present"
//    );
    @Test
    @Tag("nonParallel")
    @Order(2)
    public void verifyUnsuccessfulLoginWithEmptyPassword() {
        String username = "random_user";
        String password = "random";

        logger.info("Starting the login with empty password test.");
        setUpChrome();
        driver.navigate().to(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPasswordInput(loginPage.getPasswordInput());

        loginPage.clickOnLoginButton();

        wait
                .withMessage("Error message for missing password should be present")
                .until(ExpectedConditions.textToBePresentInElement(
                        loginPage.getErrorMessageElement(), "Password is required"));

        if (loginPage.getErrorMessageElement().getText().contains("Password is required")) {
            logger.info("Test passed, error message \"Password is required\" is found.");
        } else {
            logger.error("Test failed, error message \"Password is required\" is not found.");
        }
    }
}
