import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    public WebElement makeMyTripLogoElement(){
        return driver.findElement(By.cssSelector(".mmtLogo.makeFlex"));
    }
    public WebElement oneWayTripWebElement(){
        return driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']/span"));
    }
    public WebElement fromCityWebElement(){
        return driver.findElement(By.xpath("//label[@for='fromCity']/parent::div"));
    }
    public WebElement fromCitySearchBarDropDownVisibility(){
        return driver.findElement(By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup"));
    }
    public WebElement fromCitySearchBarTextBox(){
        return driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open"));
    }
    public List<WebElement> fromCityDropDownWebElementList(){
        return driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
    }
}