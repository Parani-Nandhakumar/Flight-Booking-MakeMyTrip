import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class flightTicketbooking {
    WebDriver driver;
    Properties properties;
    HomePageSearch homePageSearch;
    WebDriverWait wait;

    @Test
    public void driverSetup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        homePageSearch = new HomePageSearch(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        FileInputStream fileInputStream = new FileInputStream("fileProperties.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }
    @Test(enabled = false)
   public void hyperlinkCheck() throws InterruptedException {
        driver.switchTo().frame(homePageSearch.notificationFrameElement());
        Thread.sleep(1000);
        boolean isHyperlinkDisplayed = homePageSearch.closePopupNotification().isEnabled();
        if (isHyperlinkDisplayed){
            homePageSearch.closePopupNotification().click();
        }
    }
    @Test(enabled = false)
    public void loggingIn() throws InterruptedException {
        if(homePageSearch.userName().isDisplayed()) {
            homePageSearch.userName().sendKeys(properties.getProperty("userName"));
            homePageSearch.continueButtonInLoginFrame().click();
            Thread.sleep(2000);
            homePageSearch.password().sendKeys(properties.getProperty("password"));
            homePageSearch.continueButtonInLoginFrame().click();
            Thread.sleep(1000);
        }
    }
    @Test(dependsOnMethods = {"driverSetup"})
    public void closeLoginPopup() throws InterruptedException {
        Thread.sleep(2000);
        if(homePageSearch.closeButtonInLoginFrame().isEnabled()){
            homePageSearch.closeButtonInLoginFrame().click();
        }
        }
    @Test(dependsOnMethods = {"closeLoginPopup"})
    public void tripType(){
        homePageSearch.oneWayTripWebElement().click();
    }
    @Test(dependsOnMethods = {"tripType"})
    public void selectingFromCity() throws InterruptedException {
        homePageSearch.fromCityWebElement().click();
        if(homePageSearch.fromCitySearchBarDropDownVisibility().isEnabled()){
            homePageSearch.fromCitySearchBarTextBox().click();
            homePageSearch.fromCitySearchBarTextBox().sendKeys(properties.getProperty("fromCityCode"));
        }
        Thread.sleep(1000);
        List<WebElement> suggestionElementsFrom = homePageSearch.fromCityDropDownWebElementList();
        for ( WebElement w : suggestionElementsFrom){
            if(w.getText().equals(properties.getProperty("fromCityCode"))){
                wait.until(ExpectedConditions.elementToBeClickable(w)).click();
                break;
            }
        }
    }
    @Test(dependsOnMethods = {"selectingFromCity"})
    public void selectingToCity() throws InterruptedException {
        homePageSearch.toCityWebElement().click();
        if(homePageSearch.toCitySearchBarDropDownVisibility().isEnabled()){
            homePageSearch.toCitySearchBarTextBox().click();
            homePageSearch.toCitySearchBarTextBox().sendKeys(properties.getProperty("toCityCode"));
            Thread.sleep(1000);
        }
        List<WebElement> suggestionElementsTo = homePageSearch.toCityDropDownWebElementList();
        for ( WebElement w : suggestionElementsTo){
            if(w.getText().equals(properties.getProperty("toCityCode"))){
                wait.until(ExpectedConditions.elementToBeClickable(w)).click();
                break;
            }
        }
    }
    @Test(dependsOnMethods = {"selectingToCity"})
    public void departureDate(){
        homePageSearch.departureDateWebElement().click();
    }
    @Test(dependsOnMethods = {"departureDate"})
    public void travellerDetails(){
        homePageSearch.travellerGridVisibility().click();
        homePageSearch.adultTravellersCount().click();
        homePageSearch.childrenTravellersCount().click();
        homePageSearch.infantsTravellerCount().click();
        homePageSearch.travelClass().click();
        homePageSearch.travellerGridApplyButton().click();
    }
    @Test(dependsOnMethods = {"travellerDetails"})
    public void homePageSearchButton(){
        homePageSearch.homePageSearchSearchButtonWebElement().click();
    }
    }