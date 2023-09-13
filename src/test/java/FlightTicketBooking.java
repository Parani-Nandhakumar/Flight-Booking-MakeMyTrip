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
    public static void main(String[] args) throws IOException, InterruptedException {
        driverSetup();
        Thread.sleep(2000);
        homePageSearch = new HomePageSearch(driver);
        hyperlinkCheck();
        Thread.sleep(2000);
    }
    public static void check() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement makeMyTripPageElement = driver.findElement(By.cssSelector(".mmtLogo.makeFlex"));
        action.moveToElement(makeMyTripPageElement).click(makeMyTripPageElement).build().perform();
        driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']/span")).click();
        driver.findElement(By.xpath("//label[@for='fromCity']/parent::div")).click();
        if(driver.findElement(By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup")).isEnabled()){
            driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).click();
            driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("CJB");
            Thread.sleep(2000);
        }
        List<WebElement> suggestionElementsFrom = driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
        for ( WebElement w : suggestionElementsFrom){
            if(w.getText().equals("CJB")){
                Thread.sleep(2000);
                w.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='toCity']/parent::div")).click();
        if(driver.findElement(By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup.makeFlex.column.spaceBetween")).isEnabled()){
            driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).click();
            driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("SIN");
            Thread.sleep(2000);
        }
        List<WebElement> suggestionElementsTo = driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
        for ( WebElement w : suggestionElementsTo){
            if(w.getText().equals("SIN")){
                Thread.sleep(2000);
                w.click();
                break;
            }
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@aria-label,'Sep 27')]")).click();
        Thread.sleep(1000);
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