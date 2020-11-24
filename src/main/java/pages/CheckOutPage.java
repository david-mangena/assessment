package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.className("cart_button");


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterFirstName(String firstname) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(firstName).sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void enterPostalCode(String postalcode){
        driver.findElement(postalCode).sendKeys(postalcode);
    }

    public OverViewPage clickContinueBtn(){
        driver.findElement(continueBtn).click();
        return new OverViewPage(driver);
    }

}
