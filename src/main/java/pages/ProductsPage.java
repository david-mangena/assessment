package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By numOfItem = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private By addToCartBtn = By.cssSelector("#inventory_item_container > div > div > div > button");
    private By backBtn = By.cssSelector("#inventory_item_container > div > button");
    private By cartBtn = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnItem(String itemName){
        driver.findElement(By.linkText(itemName)).click();
    }

    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(addToCartBtn).click();
    }

    public void clickOnBack(){
        driver.findElement(backBtn).click();
    }

    public String getNumberOfItem(){
        return driver.findElement(numOfItem).getText();
    }

    public CartPage clickOnCart(){
        driver.findElement(cartBtn).click();
        return new CartPage(driver);
    }

}

