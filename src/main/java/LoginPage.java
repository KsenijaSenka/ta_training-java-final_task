import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
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

//    public String getErrorMessageText() {
//        //return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
//        return driver.findElement(By.xpath("//*[@id='login_button_container']")).getText();
//    }

    public WebElement getErrorMessageElement() {
        return driver.findElement(By.xpath("//*[@id='login_button_container']"));
    }

    public void clearUsernameInput(WebElement username) {
//        Actions actions=new Actions(driver);
//        //actions.doubleClick(username).sendKeys(username, "").perform();
//actions.moveToElement(username)
//        .click()
//        .sendKeys(Keys.CLEAR)
//        .perform();
//        JavascriptExecutor jsExecutor  = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].value = '';", username);
        username.sendKeys("\b\b\b\b\b\b\b\b\b\b\b");

//        getUsernameInput().click();
//
//    getUsernameInput().clear();
    }

    public void clearPasswordInput(WebElement password) {
//        Actions actions=new Actions(driver);
//        //actions.doubleClick(password).sendKeys(password, "").perform();
//        actions.moveToElement(password)
//                .click()
//                .sendKeys(Keys.CLEAR)
//                .perform();

//        JavascriptExecutor jsExecutor  = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].value = '';", password);

        password.sendKeys("\b\b\b\b\b\b\b\b\b\b\b");
//        getPasswordInput().click();
//        getPasswordInput().clear();
    }
}
