package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import util.ReadDataFromexcel;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TestCases extends BaseTests {
    private String username = "dvdmangena@gmail.com";
    private String password = "password";

    @Test
    public void TC1(){
        homePage.search_query("Faded Short Sleeve T-shirts");
        homePage.click_search_btn();
        assertTrue(homePage.search_verify()
                        .contains("Faded Short Sleeve T-shirts"),
                "product not found");
    }

    @Test
    public void TC2(){
        String[] search_criteria = {"Blouse", "Faded Short Sleeve T-shirts","Printed Summer Dress"};
        for (String search_criterion : search_criteria) {
            homePage.search_query(search_criterion);
            homePage.click_search_btn();
            assertTrue(homePage.search_verify()
                            .contains(search_criterion),
                    "product not found");
        }
    }

    @Test()
    public void TC3() throws IOException {
        ReadDataFromexcel readDataFromexcel = new ReadDataFromexcel();
        String data_value = readDataFromexcel.read_data_from_execl();
        homePage.search_query(data_value);
        homePage.click_search_btn();
        assertTrue(homePage.search_verify()
                .contains(data_value), "product: "+data_value+ " not found");
    }

    @Test
    public void TC4(){
        homePage.click_signIn_btn();
        homePage.sign_in(username,password);
        homePage.click_SubmitLogin_btn();
    }

    @Test
    public void TC5() throws InterruptedException {
        homePage.search_query("Blouse");
        homePage.click_search_btn();
        homePage.click_addToProduct();
        homePage.click_process_to_checkout();
        homePage.increase_cart_quantity("9");
        assertEquals(homePage.calculate_total(),homePage.get_total_price());
    }

    @Test
    public void TC6(){
        homePage.hoverOver();
    }
}
