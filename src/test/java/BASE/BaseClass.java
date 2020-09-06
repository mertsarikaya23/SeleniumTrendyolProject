package BASE;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static EQUIPMENTS.ConstantsPage.*;

import java.net.URL;

public class BaseClass
{
    public WebDriver Driver;
    public WebDriverWait driverWait;


    public WebDriver getDriver()
    {

        return Driver;

    }

    @Before
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver2.exe");
        Driver=new ChromeDriver();
        Driver.get(URL);
        System.out.println(Driver.getTitle());
        Driver.manage().window().maximize();
        driverWait=new WebDriverWait(Driver,3000);

    }

    public boolean isElementDisplayed(By Locater)
    {
        return Driver.findElement(Locater).isDisplayed();
    }

    public WebElement eFind(By Locater)
    {
        isElementDisplayed(Locater);

        return Driver.findElement(Locater);
    }



    public void SendKeys(By Locater, String sendValue)
    {
        isElementDisplayed(Locater);
        driverWait.until(ExpectedConditions.elementToBeClickable(Locater));
        eFind(Locater).sendKeys(sendValue);

    }

    public void eClick(By Locater)
    {

        driverWait.until(ExpectedConditions.elementToBeClickable(Locater));
        isElementDisplayed(Locater);
        eFind(Locater).click();

    }


    @After
    public void closeDriver()
    {

        Driver.quit();
    }

}
