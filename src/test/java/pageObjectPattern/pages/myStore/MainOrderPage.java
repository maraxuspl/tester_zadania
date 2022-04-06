package pageObjectPattern.pages.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainOrderPage {
    private final WebDriver driver;


    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[2]/div/div/form/div[2]/button")
    private WebElement simpleContinueAddingNewAdressButton;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[3]/div/div[2]/form/button")
    private WebElement shipingContinueAddingNewAdressButton;

    @FindBy(css = "#payment-option-1")
    private WebElement payByCheckButton;

    @FindBy(css = "#conditions_to_approve\\[terms-and-conditions\\]")
    private WebElement agreeTermsCheck;

    @FindBy(css = "div.ps-shown-by-js > button:nth-child(1)")
    private WebElement orderwithAnObligationToPay;

    public MainOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void continueWithAddress() {
        simpleContinueAddingNewAdressButton.click();
    }

    public void continueWithShipping() {
        shipingContinueAddingNewAdressButton.click();
    }

    public void payByCheck() {
        payByCheckButton.click();
        agreeTermsCheck.click();
    }

    public void clicksOrderWithAnObligationToPay(){
        orderwithAnObligationToPay.click();

    }
}
