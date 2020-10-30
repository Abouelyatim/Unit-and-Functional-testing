package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoesInfoPage extends PageObject{

    @FindBy(id ="msku-sel-1" ) WebElement color;
    @FindBy(className ="msku-sel-2" ) WebElement size;
    @FindBy(id = "isCartBtn_btn") WebElement addToCartBtn;


    public ShoesInfoPage(WebDriver driver) {
        super(driver);
    }


    public void selectSize(int index ){
        Select sizes = new Select(this.size);
        sizes.selectByIndex(index);
    }


    public void selectColor(int index ){
        Select colors = new Select(this.color);
        colors.selectByIndex(index);
    }


    public void clickaddToCart(){
        addToCartBtn.click();
    }





}
