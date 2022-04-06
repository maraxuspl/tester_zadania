package pageObjectPattern.pages.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HummingbirdPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeSelector;

    @FindBy(id = "quantity_wanted")
    private WebElement quantInput;

    @FindBy(xpath = "/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")
    private WebElement addToCartButton;

    @FindBy(css = "a.btn")
    private WebElement procedToCheckout;


    public HummingbirdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSize(String size){
        sizeSelector.sendKeys(size);
    }

    public void setQuant(String quant){
        quantInput.clear();
        quantInput.sendKeys(quant);
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void procedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        procedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(procedToCheckout));
        procedToCheckout.click();
    }
}