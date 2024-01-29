package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithIncorrectPassword {

    private WebDriver driver;

    @Given("open web url {string}")
    public void openWebUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("input username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("click login button")
    public void clickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("should failed login and showing message password are incorrect")
    public void shouldFailedLoginAndShowingMessagePasswordAreIncorrect() {
        driver.findElement(By.cssSelector(".input_error.form_input.error")).isDisplayed();
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        LoginWithIncorrectPassword login = new LoginWithIncorrectPassword();
        login.openWebUrl("https://www.saucedemo.com/");
        login.inputUsernameAndPassword("standard_user","wrong_password");
        login.clickLoginButton();
        login.shouldFailedLoginAndShowingMessagePasswordAreIncorrect();
    }
}
