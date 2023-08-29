import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlightTicketBooking {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        //waiting till popup displayed
        Thread.sleep(5000);
        //switching to iframe to handle hyperlink popup
        driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
        WebElement hyperlinkElement = driver.findElement(By.cssSelector(".close"));
        //checking if hyperlink is enabled and then closing the hyperlink
        boolean isHyperlinkDisplayed = hyperlinkElement.isEnabled();
        if (isHyperlinkDisplayed){
            hyperlinkElement.click();
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#username")).sendKeys("parani777@gmail.com");
        driver.findElement(By.cssSelector(".btnContainer.appendBottom25")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Kalamani@1969");
        driver.findElement(By.cssSelector(".btnContainer.appendBottom25")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement makeMyTripPageElement = driver.findElement(By.cssSelector(".mmtLogo.makeFlex"));
        action.moveToElement(makeMyTripPageElement).click(makeMyTripPageElement).build().perform();
}
}