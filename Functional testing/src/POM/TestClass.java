package POM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //For Firefox
        System.setProperty("webdriver.gecko.driver","C:\\Users\\TOP-LAPTOP\\Desktop\\semestre1\\OUTILS - Outils GL\\td2-sililum\\geckodriver.exe");
        // For Chrome
        //System.setProperty("webdriver.chrome.driver","/opt/webdriver/chromedriver");
        PageObject.driver = new FirefoxDriver();
        PageObject.driver.get("http://www.ebay.com");
    }


    @Test
    public void test() {
        HomePage homePage = new HomePage(PageObject.driver);
        homePage.fillSearch("shoes for men");
        homePage.submitSearch();


        ShoesPage shoesPage = new ShoesPage(PageObject.driver);
        shoesPage.clickElementByIndex(2);

        ShoesInfoPage shoesInformationPage= new ShoesInfoPage(PageObject.driver);
        shoesInformationPage.selectColor(1);
        shoesInformationPage.selectSize(1);
        shoesInformationPage.clickaddToCart();

        AddToCartPage addToCartPage = new AddToCartPage(PageObject.driver);


        Assert.assertEquals("US $15.84",addToCartPage.getTotalPrice());

    }





    @AfterClass
    public static void setUpAfterClass() throws Exception {
        PageObject.driver.close();
    }
}
