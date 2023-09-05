import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class FlightTicketBooking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        //waiting till popup displayed
        Thread.sleep(2000);
        //switching to iframe to handle hyperlink popup
        driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
        WebElement hyperlinkElement = driver.findElement(By.cssSelector(".close"));
        //checking if hyperlink is enabled and then closing the hyperlink
        boolean isHyperlinkDisplayed = hyperlinkElement.isEnabled();
        if (isHyperlinkDisplayed){
            hyperlinkElement.click();
        }
        Thread.sleep(2000);
        if(driver.findElement(By.cssSelector("#username")).isDisplayed()) {
            //driver.findElement(By.cssSelector("#username")).sendKeys("parani777@gmail.com");
            //driver.findElement(By.cssSelector(".btnContainer.appendBottom25")).click();
            //Thread.sleep(2000);
            //driver.findElement(By.cssSelector("#password")).sendKeys("Kalamani@1969");
            //driver.findElement(By.cssSelector(".btnContainer.appendBottom25")).click();
            //Thread.sleep(1000);
            Actions action = new Actions(driver);
            WebElement makeMyTripPageElement = driver.findElement(By.cssSelector(".mmtLogo.makeFlex"));
            action.moveToElement(makeMyTripPageElement).click(makeMyTripPageElement).build().perform();
        }
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