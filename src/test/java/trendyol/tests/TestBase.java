package trendyol.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import trendyol.utilities.ConfigurationReader;
import trendyol.utilities.Driver;

import java.time.Duration;


public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    //env set up
    protected String url;


    @BeforeMethod
    public void setUp() {

        url = ConfigurationReader.get("url");

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
