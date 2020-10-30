import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestEbay1 {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //For Firefox
        System.setProperty("webdriver.gecko.driver","C:\\Users\\TOP-LAPTOP\\Desktop\\semestre1\\OUTILS - Outils GL\\td2-sililum\\geckodriver.exe");
        // For Chrome
        //System.setProperty("webdriver.chrome.driver","/opt/webdriver/chromedriver");
        driver = new FirefoxDriver();
    }


    @Test
    public void test() {

        List<WebElement> brandList,carList,materialList,productList;
        WebElement carItem,actionItem,materialItem;
        int totalProductNumber;

        driver.get("https://www.ebay.com");

        carList = new ArrayList<WebElement>();
        brandList = new ArrayList<WebElement>();
        materialList = new ArrayList<WebElement>();

        WebElement categoryButton = driver.findElement(By.id("gh-shop-a"));
        categoryButton.click();


        WebElement kidToysLink  = driver.findElement(By.linkText("Kids toys"));
        kidToysLink.click();


        brandList =  driver.findElements(By.className("b-guidancecard__link"));
        actionItem=brandList.get(2);
        actionItem.click();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        carList=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("b-guidancecard__link")));

        //carList = driver.findElements(By.className("b-guidancecard__link"));
        carItem = carList.get(1);
        carItem.click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        materialList=(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("b-guidancecard__link")));

       // materialList = driver.findElements(By.className("b-guidancecard__link"));
        materialItem =materialList.get(3);
        materialItem.click();

        productList = driver.findElements(By.className("s-item"));
        totalProductNumber = productList.size();


        Assert.assertEquals(totalProductNumber,5);




    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        driver.quit();


    }




}
