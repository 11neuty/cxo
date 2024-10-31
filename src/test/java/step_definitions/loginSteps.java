package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class loginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User open the cxo web")
    public void userOpenCxoWeb(){
        driver = Hooks.driver; // Dapatkan driver di sini
        loginPage = new LoginPage(driver); // Inisialisasi LoginPage di sini
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User input {string} as company id, {string} as user id, {string} as password")
    public void userInputAsCompanyIdAsUserIdAsPassword(String cid, String uname, String pass) {
        loginPage.inputLogin(cid, uname, pass);
    }

    @Then("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("User input otp number {int}")
    public void userInputOtpNumber(int otp) {
        loginPage.inputOtp(otp);
    }

    @And("User click verifikasi")
    public void userClickVerifikasi() {
        loginPage.clickVerif();
    }

    @Then("User redirect to dashboard menu")
    public void userRedirectToDashboardMenu() {
        // Implementasi untuk verifikasi redirect jika diperlukan
    }
}
