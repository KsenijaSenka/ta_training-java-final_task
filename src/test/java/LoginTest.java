import org.junit.jupiter.api.Test;

public class LoginTest extends BasicTest {

    @Test
    public void verifySuccessfulLoginWithChrome() {
        String username = "standard_user";
        String password = "secret_sauce";

        setUpChrome();
        driver.navigate().to(url);
        loginPage = new LoginPage(driver, wait);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
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
}