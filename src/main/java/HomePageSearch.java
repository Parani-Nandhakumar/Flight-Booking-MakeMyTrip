import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageSearch {
    WebDriver driver;
    private final By notificationFrameWebElement = By.cssSelector("#webklipper-publisher-widget-container-notification-frame");
    private final By closePopupNotificationWebElement = By.cssSelector(".close");
    private final By userNameWebElement = By.cssSelector("#username");
    private final By continueButtonInLoginFrameWebElement = By.cssSelector(".btnContainer.appendBottom25");
    private final By passwordWebElement = By.cssSelector("#password");
    private final By closeButtonInLoginFrameWebElement = By.xpath("//div[@data-cy='outsideModal']/div/section/span");
    private final By oneWayTripWebElement = By.xpath("//li[@data-cy='oneWayTrip']/span");
    private final By fromCityWebElement = By.xpath("//label[@for='fromCity']/parent::div");
    private final By fromCitySearchBarDropDownVisibilityWebElement = By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup");
    private final By fromCitySearchBarTextBoxWebElement = By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open");
    private final By fromCityDropDownListWebElement = By.cssSelector(".pushRight.font14.lightGreyText.latoBold");
    private final By toCityWebElement = By.xpath("//label[@for='toCity']/parent::div");
    private final By toCitySearchBarDropDownVisibilityWebElement = By.cssSelector(".autoSuggestPlugin.hsw_autocomplePopup.makeFlex.column.spaceBetween");
    private final By toCitySearchBarTextBoxWebElement = By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open");
    private final By toCityDropDownListWebElement = By.cssSelector(".pushRight.font14.lightGreyText.latoBold");
    private final By departureDateWebElement = By.xpath("//div[contains(@aria-label,'Oct 27')]");
    private final By travellerGridVisibilityWebElement = By.cssSelector(".flt_fsw_inputBox.flightTravllers.inactiveWidget");
    private final By adultTravellersCountWebElement = By.xpath("//li[@data-cy='adults-2']");
    private final By childrenTravellersCountWebElement = By.xpath("//li[@data-cy='children-1']");
    private final By infantsTravellerCountWebElement = By.xpath("//li[@data-cy='infants-1']");
    private final By travelClassWebElement = By.xpath("//li[@data-cy='travelClass-2']");
    private final By travellerGridApplyButtonWebElement = By.cssSelector(".primaryBtn.btnApply.pushRight");
    private final By homePageSearchSearchButtonWebElement = By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn ");

    HomePageSearch(WebDriver driver){
        this.driver=driver;
    }
   public WebElement notificationFrame(){
        return driver.findElement(notificationFrameWebElement);
   }
    public WebElement closePopupNotification(){
        return driver.findElement(closePopupNotificationWebElement);
    }
    public WebElement userName(){
        return driver.findElement(userNameWebElement);
    }
    public WebElement continueButtonInLoginFrame(){
        return driver.findElement(continueButtonInLoginFrameWebElement);
    }
    public WebElement password(){
        return driver.findElement(passwordWebElement);
    }
    public WebElement closeButtonInLoginFrame(){
        return driver.findElement(closeButtonInLoginFrameWebElement);
    }
    public WebElement oneWayTrip(){ return driver.findElement(oneWayTripWebElement); }
    public WebElement fromCity(){ return driver.findElement(fromCityWebElement); }
    public WebElement fromCitySearchBarDropDownVisibility(){
        return driver.findElement(fromCitySearchBarDropDownVisibilityWebElement);
    }
    public WebElement fromCitySearchBarTextBox(){
        return driver.findElement(fromCitySearchBarTextBoxWebElement);
    }
    public List<WebElement> fromCityDropDownList(){
        return driver.findElements(fromCityDropDownListWebElement);
    }
    public WebElement toCity(){
        return driver.findElement(toCityWebElement);
    }
    public WebElement toCitySearchBarDropDownVisibility(){
        return driver.findElement(toCitySearchBarDropDownVisibilityWebElement);
    }
    public WebElement toCitySearchBarTextBox(){
        return driver.findElement(toCitySearchBarTextBoxWebElement);
    }
    public List<WebElement> toCityDropDownList(){
        return driver.findElements(toCityDropDownListWebElement);
    }
    public WebElement departureDate(){
        return driver.findElement(departureDateWebElement);
    }
    public WebElement travellerGridVisibility(){
        return driver.findElement(travellerGridVisibilityWebElement);
    }
    public WebElement adultTravellersCount(){
        return driver.findElement(adultTravellersCountWebElement);
    }
    public WebElement childrenTravellersCount(){
        return driver.findElement(childrenTravellersCountWebElement);
    }
    public WebElement infantsTravellerCount(){
        return driver.findElement(infantsTravellerCountWebElement);
    }
    public WebElement travelClass(){
        return driver.findElement(travelClassWebElement);
    }
    public WebElement travellerGridApplyButton(){
        return driver.findElement(travellerGridApplyButtonWebElement);
    }
    public WebElement homePageSearchSearchButton(){
        return driver.findElement(homePageSearchSearchButtonWebElement);
    }
}