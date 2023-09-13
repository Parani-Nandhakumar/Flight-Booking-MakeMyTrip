import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageSearch {
    static WebDriver driver;
    HomePageSearch(WebDriver driver){
        HomePageSearch.driver = driver;
    }
    public WebElement notificationFrameElement(){
        return driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
    }
    public WebElement closePopupNotification(){
        return driver.findElement(By.cssSelector(".close"));
    }
    public WebElement userName(){
        return driver.findElement(By.cssSelector("#username"));
    }
    public WebElement continueButtonInLoginFrame(){
        return driver.findElement(By.cssSelector(".btnContainer.appendBottom25"));
    }
    public WebElement password(){
        return driver.findElement(By.cssSelector("#password"));
    }
}