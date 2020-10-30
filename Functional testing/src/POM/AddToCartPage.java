package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageObject {

    @FindBy(xpath = "*[@id=\"mainContent\"]/div/div[4]/div/table/tr[4]/td[2]/span/span") WebElement totalPrice;


    public AddToCartPage(WebDriver driver) {
        super(driver);
    }



    public String getTotalPrice(){

        return totalPrice.getText();


    }
}
