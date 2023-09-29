import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenersTest implements ITestListener {
    WebDriver driver=null;

    @Override
    public void onTestFailure(ITestResult result) {
        String fileName = result.getMethod().getMethodName();
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");
        File outputFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(outputFile,new File("D:\\Parani\\MyCode\\FlightTicketBooking\\Screenshots\\"+fileName+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }