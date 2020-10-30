import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestFacebook {

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

        driver.get("https://m.facebook.com/story.php?story_fbid=717598995669459&id=100022580951295&refid=17&_ft_=mf_story_key.717598995669459%3Atop_level_post_id.717598995669459%3Atl_objid.717598995669459%3Acontent_owner_id_new.100022580951295%3Athrowback_story_fbid.717598995669459%3Astory_location.4%3Athid.100022580951295%3A306061129499414%3A2%3A0%3A1590994799%3A-6480971874120027454&__tn__=%2AW-R");
        // Select langSearch =new Select(driver.findElements(By.id("searchLanguage")));
        // ( driver.findElement(By.id("searchLanguage")))
       // Select langSearch = new Select(driver.findElement(By.id("searchLanguage")));
       // langSearch.selectByValue("en");



        WebElement inputSearch77 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/a[1]"));
        inputSearch77.click();

        WebElement inputSearch = driver.findElement(By.id("m_login_email"));
        inputSearch.sendKeys("ismailberkane2019@gmail.com");


        WebElement inputSearc2h = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr/td/div[3]/div[2]/form/ul/li[2]/section/input"));
        inputSearc2h.sendKeys("ismailkiko");


        WebElement inputSearc42h = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/table/tbody/tr/td/div[3]/div[2]/form/ul/li[3]/input"));
        inputSearc42h.click();





        for (int i=0;i<900;i++){
            WebElement header =  (new WebDriverWait(driver, 60)).
                    until(ExpectedConditions.presenceOfElementLocated(By.id("composerInput")));
            header.sendKeys("1");

            WebElement inputSearc4244h = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div/div[6]/form[1]/table/tbody/tr/td[2]/div/input"));
            inputSearc4244h.click();
            System.out.println("yyy:"+i);
        }



        //Assert.assertEquals("wolf",header.getText());

    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        driver.quit();


    }
}
