package pageObjectPattern.pages.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformationPage {

    private WebDriver driver;

    @FindBy(name = "birthday")
    private WebElement birthdayInput;

    @FindBy(name = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/address-form/footer")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@data-alert='success']//li")
    private WebElement successInformation;

    public UserInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setBirthDate(String birthDate) {
        birthdayInput.clear();
        birthdayInput.sendKeys(birthDate);
    }

    public void signInForNewsletter() {
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void signOutFromNewsletter() {
        if (newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void submitUserInfo(String password) {
        passwordInput.sendKeys(password);
        saveButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}
