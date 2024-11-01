import org.junit.jupiter.api.Test;

public class LoginTest extends BasicTest {

    @Test
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        setUpChrome();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }
}