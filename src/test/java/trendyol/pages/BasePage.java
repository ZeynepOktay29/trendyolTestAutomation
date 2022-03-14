package trendyol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import trendyol.utilities.Driver;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//p[text()='Giriş Yap']")
    public WebElement signInButton;

    @FindBy(xpath = "//p[text()='Sepetim']")
    public WebElement basketButton;

    @FindBy(className = "login-button")
    public WebElement baseLoginButton;

    @FindBy(className = "modal-close")
    public WebElement closeModal;

    @FindBy(className = "search-box")
    public WebElement searchInput;


}
