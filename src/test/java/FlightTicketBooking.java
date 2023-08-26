import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }
}