package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoesPage extends PageObject{
    @FindBy(className = "s-item__title") List<WebElement> shoesList;
    WebElement shoes;


    public ShoesPage(WebDriver driver) {
        super(driver);

    }


    public void clickElementByIndex(int index)
    {
      shoes=shoesList.get(index);
      shoes.click();

    }

}
