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

        setUpChrome();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
                "The page title should be 'Swag Labs'.");
    }

    @Test
    public void verifySuccessfulLoginWithEdge() {
        String username = "standard_user";
        String password = "secret_sauce";

        setUpEdge();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        inventoryPage = new InventoryPage(driver, wait);

        assertEquals("Swag Labs", inventoryPage.getInventoryPageTitle(),
                "The page title should be 'Swag Labs'.");
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
    }
}
