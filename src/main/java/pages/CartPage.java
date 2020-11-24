package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By removeBtn = By.xpath("//*[@id=\"cart_contents_container\"]//div[1]/div[3]/div[2]/div[2]/button");
    private By checkOutBtn = By.className("checkout_button");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnRemoveBtn() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(removeBtn).click();
    }

    public CheckOutPage clickOnCheckOut(){
        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }

}
