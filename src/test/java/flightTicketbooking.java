import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
@Listeners(ListenersTest.class)
public class flightTicketbooking {
    WebDriver driver;
    Properties properties;
    HomePageSearch homePageSearch;
    WebDriverWait wait;
    ChromeOptions options;
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;

    @BeforeClass(dependsOnMethods = {"driverSetup"})
    public void setDriver(ITestContext context){
        System.out.println("set driver executed");
        context.setAttribute("WebDriver",driver);
    }
    @BeforeClass()
    public void driverSetup() throws IOException {
        System.out.println("driver setup executed");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        driver = new ChromeDriver(options);
        homePageSearch = new HomePageSearch(driver);
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\Report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        FileInputStream fileInputStream = new FileInputStream("fileProperties.properties");
        properties = new Properties();
        properties.load(fileInputStream);
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }
    public void extentReportTestMethod(String methodName){
        ExtentTest extentTest = extentReports.createTest(methodName);
    }
    public void extentReportFlushMethod(){
        extentReports.flush();
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
    @Test()
    public void closeLoginPopup() throws InterruptedException, IOException {
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
        Thread.sleep(2000);
        try{if(homePageSearch.closeButtonInLoginFrame().isDisplayed()){
            homePageSearch.closeButtonInLoginFrame().click();
        }}catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
        extentReportFlushMethod();
        }
    @Test(dependsOnMethods = {"closeLoginPopup"})
    public void tripType(){
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
        homePageSearch.oneWayTripWebElement().click();
        extentReportFlushMethod();
    }
    @Test(dependsOnMethods = {"tripType"})
    public void selectingFromCity() throws InterruptedException {
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
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
        extentReportFlushMethod();
    }
    @Test(dependsOnMethods = {"selectingFromCity"})
    public void selectingToCity() throws InterruptedException {
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
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
        extentReportFlushMethod();
    }
    @Test(dependsOnMethods = {"selectingToCity"})
    public void departureDate(){
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
        homePageSearch.departureDateWebElement().click();
        extentReportFlushMethod();
    }
    @Test(dependsOnMethods = {"departureDate"})
    public void travellerDetails(){
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
        wait.until(ExpectedConditions.visibilityOf(homePageSearch.travellerGridVisibility())).click();
        //homePageSearch.travellerGridVisibility().click();
        homePageSearch.adultTravellersCount().click();
        homePageSearch.childrenTravellersCount().click();
        homePageSearch.infantsTravellerCount().click();
        homePageSearch.travelClass().click();
        homePageSearch.travellerGridApplyButton().click();
        extentReportFlushMethod();
    }
    @Test(dependsOnMethods = {"travellerDetails"})
    public void homePageSearchButton(){
        extentReportTestMethod(Thread.currentThread().getStackTrace()[1].getMethodName());
        homePageSearch.homePageSearchSearchButtonWebElement().click();
        extentReportFlushMethod();
    }
    }