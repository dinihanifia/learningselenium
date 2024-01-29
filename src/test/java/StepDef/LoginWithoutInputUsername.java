package StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithoutInputUsername {

    private WebDriver driver;

    @Given("open web url {string}")
    public void openWebUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
    }

    @And("input password {string}")
    public void inputPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("click login button")
    public void clickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("should failed login and showing message password are incorrect")
    public void shouldFailedLoginAndShowingMessagePasswordAreIncorrect() {
        driver.findElement(By.cssSelector(".error-message-container.error")).isDisplayed();
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        LoginWithoutInputUsername login = new LoginWithoutInputUsername();
        login.openWebUrl("http://www.saucedemo.com");
        login.inputPassword("secret-sauce");
        login.clickLoginButton();
        login.shouldFailedLoginAndShowingMessagePasswordAreIncorrect();
    }
}
