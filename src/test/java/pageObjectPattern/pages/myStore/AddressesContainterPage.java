package pageObjectPattern.pages.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesContainterPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/main/section/div/div/section/section/aside/div/article")
    private WebElement adressInfo;

    public AddressesContainterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAdressInfo() {
        return adressInfo.getText();
    }
}