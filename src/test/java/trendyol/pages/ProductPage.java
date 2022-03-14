package trendyol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//*[@id='search-app']//h1")
    public WebElement description;

    @FindBy(className = "prdct-desc-cntnr-name")
    public List<WebElement> productDescription;

    @FindBy(id = "container")
    public WebElement page;

    @FindBy(className = "prdct-desc-cntnr-wrppr")
    public List<WebElement> productButton;

    @FindBy(css = "button.add-to-basket")
    public WebElement addToBasketButton;
}
