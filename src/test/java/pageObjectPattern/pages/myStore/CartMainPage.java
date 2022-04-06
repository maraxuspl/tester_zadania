package pageObjectPattern.pages.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartMainPage {

    private final WebDriver driver;

    @FindBy(css = "a.btn")
    private WebElement procedToCheckout;

    public CartMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void procedToCheckout(){
        procedToCheckout.click();
    }
}