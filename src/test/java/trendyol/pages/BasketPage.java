package trendyol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{

    @FindBy(className = "pb-item")
    public WebElement basketProductName;

    @FindBy(className = "i-trash")
    public WebElement deleteProductButton;

    @FindBy(xpath = "//button[text()='Sil']")
    public WebElement deleteProductConfirmButton;

    @FindBy(xpath = "(//div[@id='pb-container']//span)[1]")
    public WebElement emptyBasketText;
}
