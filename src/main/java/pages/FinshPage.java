package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinshPage {
    private WebDriver driver;

    private By statusMsg = By.className("complete-header");

    public FinshPage(WebDriver driver){
        this.driver = driver;
    }

    public String getStatusMsg(){
        return driver.findElement(statusMsg).getText();
    }
}
