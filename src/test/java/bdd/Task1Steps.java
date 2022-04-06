package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.myStore.AddressesContainterPage;
import pageObjectPattern.pages.myStore.LoginPage;
import pageObjectPattern.pages.myStore.NewAddressPage;

public class Task1Steps {

    private WebDriver driver;



    @Given("User is logged in to CodersLab shop")
    public void userOpensBrowser() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("maraxuspl@gmail.com", "tatatata");
    }

    @When("User goes to UserAdressPage")
    public void userGoesToUserAdressPage() {
        driver.findElement(By.linkText("Addresses")).click();
    }

    @And("User clicks CreateNewAdress")
    public void userClicksCreateNewAdress() {
        driver.findElement(By.partialLinkText("Create new address")).click();
    }

    @When("user fills {string},{string},{string},{string},{string},{string}, and User click save")
    public void userFillsAndUserClickSave(String alias, String adress, String city, String postalCode, String country, String phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.setNewAdressesText(alias, adress, city, postalCode, phone, country);
    }

    @Then("User sees {string}")
    public void userSees(String infoString) {
        AddressesContainterPage addressesContainterPage = new AddressesContainterPage(driver);
        Assertions.assertEquals(infoString, addressesContainterPage.getAdressInfo());
    }
}