import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSearch {
    static WebDriver driver;
    HomePageSearch(WebDriver driver){
        HomePageSearch.driver = driver;
    }
    public WebElement notificationFrameElement(){
        WebElement popupNotificationFrameElement = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
        return popupNotificationFrameElement;
    }
    public WebElement closePopupNotification(){
        WebElement popupNotificationElement = driver.findElement(By.cssSelector(".close"));
        return popupNotificationElement;
    }
}