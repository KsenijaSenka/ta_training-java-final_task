package pages;

import enums.BrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.xpath("//input[@id=\"password\"]"));
    }

    public void enterUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickOnLoginButton() {
        wait
                .withMessage("Button is not clickable")
                .until(ExpectedConditions.elementToBeClickable(getLoginButton())).click();
    }

    public WebElement getErrorMessageElement() {
        return driver.findElement(By.xpath("//*[@id='login_button_container']"));
    }

    public void clearUsernameInput(BrowserType browserType) {

        switch (browserType) {
            case CHROME, EDGE:
                getUsernameInput().click();
                getUsernameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                break;
            case FIREFOX:
                getUsernameInput().clear();
                getUsernameInput().sendKeys(Keys.ENTER);
                break;
        }
    }

    public void clearPasswordInput(BrowserType browserType) {

        switch (browserType) {
            case CHROME, EDGE:
                getPasswordInput().click();
                getPasswordInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
                break;
            case FIREFOX:
                getPasswordInput().clear();
                getPasswordInput().sendKeys(Keys.ENTER);
                break;
        }
    }
}
