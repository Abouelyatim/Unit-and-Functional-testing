import static org.junit.Assert.*;

import java.util.List;


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


public class TestWikipedia {

    static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //For Firefox
        System.setProperty("webdriver.gecko.driver","D:\\1cpi\\semestre 7\\OUTILS - Outils GL\\tp 2019\\2-silinum\\geckodriver.exe");
        // For Chrome
        //System.setProperty("webdriver.chrome.driver","/opt/webdriver/chromedriver");
        driver = new FirefoxDriver();
    }


    @Test
    public void test() {

        driver.get("https://www.wikipedia.org/");
       // Select langSearch =new Select(driver.findElements(By.id("searchLanguage")));
               // ( driver.findElement(By.id("searchLanguage")))
        Select langSearch = new Select(driver.findElement(By.id("searchLanguage")));
        langSearch.selectByValue("en");

        WebElement inputSearch = driver.findElement(By.id("searchInput"));
        inputSearch.sendKeys("Mutation testing");
        inputSearch.submit();


        WebElement header =  (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("firstHeading")));

        Assert.assertEquals("Mutation testing",header.getText());

    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        driver.quit();


    }




}
