package pageObjectPattern.pages.myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private final WebDriver driver;


    @FindBy(name = "alias")
    private WebElement aliasTextInput;

    @FindBy(name = "address1")
    private WebElement adress1TextInput;

    @FindBy(name = "city")
    private WebElement cityTextInput;

    @FindBy(name = "postcode")
    private WebElement postalTextInput;

    @FindBy(name = "phone")
    private WebElement phoneTextInput;

    @FindBy(name = "id_country")
    private WebElement countrySelector;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div/div/form/footer/button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNewAdressesText(String alias, String adress, String city, String postalCode, String phone, String country){
        aliasTextInput.sendKeys(alias);
        adress1TextInput.sendKeys(adress);
        cityTextInput.sendKeys(city);
        postalTextInput.sendKeys(postalCode);
        phoneTextInput.sendKeys(phone);
        countrySelector.sendKeys(country);
        saveButton.click();
    }



}