import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class FlightTicketBooking {
    static WebDriver driver;
    static Properties properties;
    static HomePageSearch homePageSearch;

    public static void driverSetup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        FileInputStream fileInputStream = new FileInputStream("fileProperties.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }
    public static void hyperlinkCheck() throws InterruptedException {
        driver.switchTo().frame(homePageSearch.notificationFrameElement());
        Thread.sleep(1000);
        boolean isHyperlinkDisplayed = homePageSearch.closePopupNotification().isEnabled();
        if (isHyperlinkDisplayed){
            homePageSearch.closePopupNotification().click();
        }
    }
    public static void loggingIn() throws InterruptedException {
        if(homePageSearch.userName().isDisplayed()) {
            homePageSearch.userName().sendKeys(properties.getProperty("userName"));
            homePageSearch.continueButtonInLoginFrame().click();
            Thread.sleep(2000);
            homePageSearch.password().sendKeys(properties.getProperty("password"));
            homePageSearch.continueButtonInLoginFrame().click();
            Thread.sleep(1000);
        }
    }
    public static void closeLoginPopup(){
        Actions action = new Actions(driver);
        action.moveToElement(homePageSearch.makeMyTripLogoElement()).click(homePageSearch.makeMyTripLogoElement()).build().perform();
    }
    public static void tripType(){
        homePageSearch.oneWayTripWebElement().click();
    }
    public static void selectingFromCity() throws InterruptedException {
        homePageSearch.fromCityWebElement().click();
        if(homePageSearch.fromCitySearchBarDropDownVisibility().isEnabled()){
            homePageSearch.fromCitySearchBarTextBox().click();
            homePageSearch.fromCitySearchBarTextBox().sendKeys(properties.getProperty("fromCityCode"));
            Thread.sleep(2000);
        }
        List<WebElement> suggestionElementsFrom = homePageSearch.fromCityDropDownWebElementList();
        for ( WebElement w : suggestionElementsFrom){
            if(w.getText().equals(properties.getProperty("fromCityCode"))){
                Thread.sleep(2000);
                w.click();
                break;
            }
        }
    }
    public static void selectingToCity() throws InterruptedException {
        homePageSearch.toCityWebElement().click();
        if(homePageSearch.toCitySearchBarDropDownVisibility().isEnabled()){
            homePageSearch.toCitySearchBarTextBox().click();
            homePageSearch.toCitySearchBarTextBox().sendKeys(properties.getProperty("toCityCode"));
            Thread.sleep(2000);
        }
        List<WebElement> suggestionElementsTo = homePageSearch.toCityDropDownWebElementList();
        for ( WebElement w : suggestionElementsTo){
            if(w.getText().equals(properties.getProperty("toCityCode"))){
                Thread.sleep(2000);
                w.click();
                break;
            }
        }
    }
    public static void departureDate(){
        homePageSearch.departureDateWebElement().click();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        driverSetup();
        Thread.sleep(2000);
        homePageSearch = new HomePageSearch(driver);
        hyperlinkCheck();
        Thread.sleep(2000);
        loggingIn();
        closeLoginPopup();
        tripType();
        Thread.sleep(2000);
        selectingFromCity();
        Thread.sleep(2000);
        selectingToCity();
        Thread.sleep(2000);
        departureDate();
        Thread.sleep(1000);

    }
    public static void check() throws InterruptedException {
        driver.findElement(By.cssSelector(".fsw_inputBox.flightTravllers.inactiveWidget")).click();
        driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
        driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();
        driver.findElement(By.xpath("//li[@data-cy='infants-1']")).click();
        driver.findElement(By.xpath("//li[@data-cy='travelClass-2']")).click();
        driver.findElement(By.cssSelector(".primaryBtn.btnApply.pushRight")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//ul[@class='specialFareNew']/li[3]")).click();
        driver.findElement(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn ")).click();
        Thread.sleep(10000);
        if(driver.findElement(By.cssSelector(".commonOverlay ")).isEnabled()){
            driver.findElement(By.cssSelector(".bgProperties.icon20.overlayCrossIcon")).click();
        }
    }
    }