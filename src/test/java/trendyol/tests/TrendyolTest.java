package trendyol.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import trendyol.pages.BasketPage;
import trendyol.pages.LoginPage;
import trendyol.pages.ProductPage;
import trendyol.utilities.ConfigurationReader;

import java.util.Set;

public class TrendyolTest extends TestBase{


    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();


    @Test
    public void end2endTest() throws InterruptedException {
        String expectedTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        wait.until(ExpectedConditions.visibilityOf(loginPage.closeModal)).click();

        loginPage.signInButton.click();

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput)).sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();


        Thread.sleep(1000);

        String productName = "iphone";
        productPage.searchInput.sendKeys(productName + Keys.ENTER);

        String expectedDescription = productPage.description.getText();
        Assert.assertEquals(productName,expectedDescription);
        System.out.println("Arama Sonucu : " + productPage.description.getText());

        int productIndex = 9;

        String productDescription = productPage.productDescription.get(productIndex).getText();

        productPage.page.click();

        actions.moveToElement(productPage.productButton.get(productIndex));
        productPage.productButton.get(productIndex).click();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        productPage.addToBasketButton.click();

        productPage.basketButton.click();

        wait.until(ExpectedConditions.visibilityOf(basketPage.basketProductName));

        String actualProductDescription = basketPage.basketProductName.getText();

        Assert.assertTrue(actualProductDescription.contains(productDescription));

        basketPage.deleteProductButton.click();

        basketPage.deleteProductConfirmButton.click();

        wait.until(ExpectedConditions.visibilityOf(basketPage.emptyBasketText));

        String expectedMessage = "Sepetinde ürün bulunmamaktadır.";

        String actualMessage = basketPage.emptyBasketText.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
