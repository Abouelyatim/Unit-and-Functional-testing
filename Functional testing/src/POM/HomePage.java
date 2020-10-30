package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(id = "gh-ac") WebElement inputSreach;


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void fillSearch(String searchMessage) {

        inputSreach.sendKeys(searchMessage);

    }


    public void submitSearch() {
        inputSreach.submit();
    }
}