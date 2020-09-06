package TEST;

import junit.framework.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.ElementNotInteractableException.*;
import BASE.BaseClass;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static EQUIPMENTS.ConstantsPage.*;

public class TestPage extends BaseClass
{

    WebDriver Driver;
    public TestPage()
    {
        Driver=getDriver();

    }

    public void loging() throws InterruptedException
    {
        //Assert.assertTrue(Driver.getCurrentUrl()=="https://www.trendyol.com/");

        eClick(By.className(POPUPCLOSE));
        eClick(By.cssSelector(SINGIN));
        //elementClick(By.cssSelector(CLICKSING));
        Thread.sleep(1000);
        SendKeys(By.cssSelector(USERNAME),"WRITE-USERNAME");
        SendKeys(By.cssSelector(PASSWORD),"WRITE-PASSWORD");
        eClick(By.cssSelector(BUTTONIN));

    }

    public void searchComputer() throws InterruptedException
    {

        Thread.sleep(1000);
        SendKeys(By.cssSelector(SEARCHAREA),"Bilgisayar");
        eClick(By.cssSelector(SEARCHCLICK));

    }

    public void addRnd()
    {
        List<WebElement> bilgisayarlar = Driver.findElements(By.cssSelector(RANDOMPC));
        bilgisayarlar.get(new Random().nextInt(bilgisayarlar.size())).click();

        eClick(By.cssSelector(ADDBASKET));

    }

    public void myBaskett()
    {
        eClick(By.cssSelector(MyBASKET));

        WebElement ListP = Driver.findElement(By.cssSelector(ListPRIZE));
        String check = ListP.getText();
        WebElement BasketPrize = Driver.findElement(By.cssSelector(PRIZE));
        String check2 = BasketPrize.getText();
        Assert.assertEquals(check,check2);
        eClick(By.cssSelector(INCREASE));
    }

    public void deleteProduct()
    {
        WebElement value =Driver.findElement(By.cssSelector(DEGER));
        String deger = value.getAttribute("value");
        if (deger == "2")
        {
            eClick(By.cssSelector(REMOVE));
        }
    }


}
