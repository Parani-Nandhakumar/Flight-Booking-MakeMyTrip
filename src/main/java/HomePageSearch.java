import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageSearch {
    WebDriver driver;
    HomePageSearch(WebDriver driver){
        this.driver=driver;
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
    public WebElement closeButtonInLoginFrame(){
        return driver.findElement(By.xpath("//div[@data-cy='outsideModal']/div/section/span"));
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
    public WebElement toCityWebElement(){
        return driver.findElement(By.xpath("//label[@for='toCity']/parent::div"));
    }
    public WebElement toCitySearchBarDropDownVisibility(){
        return driver.findElement(By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup.makeFlex.column.spaceBetween"));
    }
    public WebElement toCitySearchBarTextBox(){
        return driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open"));
    }
    public List<WebElement> toCityDropDownWebElementList(){
        return driver.findElements(By.cssSelector(".pushRight.font14.lightGreyText.latoBold"));
    }
    public WebElement departureDateWebElement(){
        return driver.findElement(By.xpath("//div[contains(@aria-label,'Oct 27')]"));
    }
    public WebElement travellerGridVisibility(){
        return driver.findElement(By.cssSelector(".flt_fsw_inputBox.flightTravllers.inactiveWidget"));
    }
    public WebElement adultTravellersCount(){
        return driver.findElement(By.xpath("//li[@data-c='adults-2']"));
    }
    public WebElement childrenTravellersCount(){
        return driver.findElement(By.xpath("//li[@data-cy='children-1']"));
    }
    public WebElement infantsTravellerCount(){
        return driver.findElement(By.xpath("//li[@data-cy='infants-1']"));
    }
    public WebElement travelClass(){
        return driver.findElement(By.xpath("//li[@data-cy='travelClass-2']"));
    }
    public WebElement travellerGridApplyButton(){
        return driver.findElement(By.cssSelector(".primaryBtn.btnApply.pushRight"));
    }
    public WebElement homePageSearchSearchButtonWebElement(){
        return driver.findElement(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn "));
    }
}