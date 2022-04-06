package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.myStore.CartMainPage;
import pageObjectPattern.pages.myStore.HummingbirdPage;
import pageObjectPattern.pages.myStore.LoginPage;
import pageObjectPattern.pages.myStore.MainOrderPage;

import java.io.File;
import java.io.IOException;

public class Task2Steps {

    private WebDriver driver;

    private HummingbirdPage hummingbirdPage;

    private MainOrderPage mainOrderPage;

    @Given("User is logged to CodersLab shop")
    public void userOpensBrowser() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        hummingbirdPage = new HummingbirdPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("maraxuspl@gmail.com", "tatatata");
    }

    @When("User chooses Hummingbird Printed Sweater")
    public void userChoosesHummingbirdPrintedSweater() {
        driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[1]/div/a/img")).click();
    }

    @Then("User chooses size: {string}")
    public void userChoosesSize(String size) {
        hummingbirdPage.setSize(size);
    }

    @Then("User chooses quant: {string}")
    public void userChoosesQuant(String quant) {
        hummingbirdPage.setQuant(quant);

    }

    @Then("User adds product to cart")
    public void userAddsProductToCart() {
        hummingbirdPage.clickAddToCartButton();
    }

    @Then("User goes to checkout options")
    public void userGoesToCheckoutOptions() {
        hummingbirdPage.procedToCheckout();
        CartMainPage cartMainPage = new CartMainPage(driver);
        cartMainPage.procedToCheckout();
    }

    @Then("User check address")
    public void userCheckAddress() {
        mainOrderPage = new MainOrderPage(driver);
        mainOrderPage.continueWithAddress();
    }


    @Then("User chooses PrestaShop")
    public void userChoosesPrestaShop() {
        mainOrderPage.continueWithShipping();
    }

    @Then("User chooses payment Pay by Check")
    public void userChoosesPaymentPayByCheck() {
        mainOrderPage.payByCheck();
    }

    @Then("User clicks order with an obligation to pay")
    public void userClicksOrderWithAnObligationToPay() {
        mainOrderPage.clicksOrderWithAnObligationToPay();
    }

    @Then("Screenshot with confirmation is made")
    public void screenshotWithConfirmationIsMade() {
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("seleniumFile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}