package StepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    private WebDriver driver;

    @Given("open web url {string}")
    public void openWebUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }


    @And("Input username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        WebElement usernameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Should success login and redirect to homepage")
    public void shouldSuccessLoginAndRedirectToHomepage() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.openWebUrl("https://www.saucedemo.com/");
        login.inputUsernameAndPassword("standard_user", "secret_sauce");
        login.clickLoginButton();
        login.shouldSuccessLoginAndRedirectToHomepage();
    }
}
