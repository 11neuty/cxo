package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver must not be null");
        }
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLoginPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement verifyLoginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[text()='Login']")));
        return verifyLoginPage.isDisplayed();
    }

    public void inputLogin(String cid, String uname, String pass) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement inputCid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name = 'corporate']")));
        inputCid.click();
        inputCid.sendKeys(cid);

        WebElement inputUname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name = 'username']")));
        inputUname.click();
        inputUname.sendKeys(uname);

        WebElement inputPass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@name = 'password']")));
        inputPass.click();
        inputPass.sendKeys(pass);
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/button[@id = 'login-btn']")));
        loginButton.click();
    }

    public void inputOtp(int otp) {
        String otpString = String.valueOf(otp);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        for (int i = 0; i < otpString.length(); i++) {
            WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div/div/input[@id='pin-input-:r62:-" + i + "']")
            ));

            otpField.click();
            otpField.sendKeys(String.valueOf(otpString.charAt(i)));
        }
    }


    public void clickVerif(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement verifField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button")));
        verifField.click();
    }
}
