package pages;

<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HomePage {
    private static WebDriver driver;
    private final By product_name = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
    private final By search_query = By.id("search_query_top");
    private final By searchBtn = By.name("submit_search");

    private final By sign_in_btn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private final By email = By.id("email");
    private final By passwd = By.id("passwd");
    private final By submit_Login = By.id("SubmitLogin");

    private final By add_to_product = By.cssSelector("#center_column > ul > li > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");
    private final By process_to_checkout = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    private final By cart_quantity_inpot = By.cssSelector("#product_2_7_0_0 > td.cart_quantity.text-center > input.cart_quantity_input.form-control.grey");

    private String qty;
    private static final By total_product = By.cssSelector("#product_2_7_0_0 > td.cart_total");






    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    public void search_query(String search_product){
        driver.findElement(search_query).clear();
        driver.findElement(search_query).sendKeys(search_product);
    }

    public void click_search_btn(){
        driver.findElement(searchBtn).submit();
    }

    public String search_verify(){
        return driver.findElement(product_name).getText();
    }

    public void sign_in(String username, String password){
        driver.findElement(email).sendKeys(username);
        driver.findElement(passwd).sendKeys(password);

    }

    public void click_signIn_btn(){
        driver.findElement(sign_in_btn).click();
    }

    public MyAccountPage click_SubmitLogin_btn(){
        driver.findElement(submit_Login).click();
        return new MyAccountPage(driver);
    }

    public void click_addToProduct(){
        driver.findElement(add_to_product).click();
    }

    public void click_process_to_checkout(){
        driver.findElement(process_to_checkout).click();
    }

    public void increase_cart_quantity(String qty){
        this.qty = qty;
        driver.findElement(cart_quantity_inpot).clear();
        driver.findElement(cart_quantity_inpot).sendKeys(qty);
    }

    public int calculate_total(){
        int unit_price = 27;
        int product_total = Integer.parseInt(qty) * unit_price;
        return product_total;
    }

    public static int get_total_price() throws InterruptedException {
        Thread.sleep(1500);
        String total_price = driver.findElement(total_product).getText();
        String trim_string = total_price.replace("$","").replace(".00","");
        int new_total_price=Integer.parseInt(trim_string);
        return new_total_price;
    }

    public void hoverOver(){
        WebElement btn_manu = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1)"));

        Actions action = new Actions(driver);
        action.moveToElement(btn_manu).build().perform();

        WebElement btn_women = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1)>a"));
        List<WebElement> anchorTags = btn_women.findElements(By.tagName("a"));

        for (WebElement menu: anchorTags ){
            if(menu.getText().equals("Blouses")){
                menu.click();
                break;
            }
        }
    }
=======
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        driver.get("https://www.saucedemo.com/");

        return new LoginPage(driver);
    }

>>>>>>> 30e2e9c3eacfa864a973ca9ce0b676f4e7baf79d
}
