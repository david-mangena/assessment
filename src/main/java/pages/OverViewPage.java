package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage {
    private WebDriver driver;

    private By finishBtn = By.className("cart_button");

    public OverViewPage(WebDriver driver) {
        this.driver = driver;
    }

    public FinshPage clickFinishBtn() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(finishBtn).click();
        return new FinshPage(driver);
    }
}
