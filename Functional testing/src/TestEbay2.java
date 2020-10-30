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

public class TestEbay2 {
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
        driver.get("https://www.ebay.com");



        WebElement inputSreach=driver.findElement(By.id("gh-ac"));


        inputSreach.sendKeys("shoes for men");

        inputSreach.submit();


        List<WebElement>shoesList=new ArrayList<WebElement>();

        shoesList=(new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("s-item__title")));

        //shoesList=driver.findElements(By.className("s-item__title"));


        WebElement shoes=shoesList.get(2);
        shoes.click();

        //Select colors = new Select(driver.findElement(By.id("msku-sel-1")));
        Select colors=new Select((new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfElementLocated(By.className("msku-sel-1"))));
        colors.selectByIndex(0);

        Select sizes = new Select(driver.findElement(By.id("msku-sel-2")));
        //Select sizes=new Select((new WebDriverWait(driver,50)).until(ExpectedConditions.presenceOfElementLocated(By.className("msku-sel-2"))));

        sizes.selectByIndex(0);

        WebElement addToCartBtn = driver.findElement(By.id("isCartBtn_btn"));
        addToCartBtn.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/table/tr[4]/td[2]/span/span"));


        Assert.assertEquals("US $15.84",totalPrice.getText());




    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        driver.quit();
    }




}

