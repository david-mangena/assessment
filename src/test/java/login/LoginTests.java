package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testStandardUserSuccessfulLogin() throws InterruptedException {
        LoginPage loginTests = homePage.clickFormAuthentication();
        loginTests.setUsername("standard_user");
        loginTests.setPassword("secret_sauce");

        ProductsPage productsPage = loginTests.clickLoginButton();
        productsPage.clickOnItem("Sauce Labs Backpack");
        productsPage.clickOnAddToCart();
        productsPage.clickOnBack();
        productsPage.clickOnItem("Sauce Labs Bolt T-Shirt");
        productsPage.clickOnAddToCart();
        productsPage.clickOnBack();
        productsPage.clickOnItem("Sauce Labs Bike Light");
        productsPage.clickOnAddToCart();
        productsPage.clickOnBack();
        productsPage.clickOnItem("Test.allTheThings() T-Shirt (Red)");
        productsPage.clickOnAddToCart();
        productsPage.clickOnBack();
        assertEquals(productsPage.getNumberOfItem(), "4", "Number of Item in Cart is incorrect");

        CartPage cartPage = productsPage.clickOnCart();
        cartPage.clickOnRemoveBtn();
        assertEquals(productsPage.getNumberOfItem(),"3","Number of Item in Cart is incorrect");

        CheckOutPage checkOutPage = cartPage.clickOnCheckOut();
        checkOutPage.enterFirstName("John");
        checkOutPage.enterLastName("Doe");
        checkOutPage.enterPostalCode("2190");

        OverViewPage overViewPage = checkOutPage.clickContinueBtn();
        FinshPage finshPage = overViewPage.clickFinishBtn();
        assertEquals(finshPage.getStatusMsg(),"THANK YOU FOR YOUR ORDER","Status message is incorrect");
    }

    @Test
    public void testLocked_out_user(){
        LoginPage loginTests = homePage.clickFormAuthentication();
        loginTests.setUsername("locked_out_user");
        loginTests.setPassword("secret_sauce");

        ProductsPage productsPage = loginTests.clickLoginButton();
        assertEquals(loginTests.getErrorMsg(),"Epic sadface: Sorry, this user has been locked out.","This user has been locked out");
    }

    @Test
    public void testProblem_user() throws InterruptedException {
        LoginPage loginTests = homePage.clickFormAuthentication();
        loginTests.setUsername("problem_user");
        loginTests.setPassword("secret_sauce");

        ProductsPage productsPage = loginTests.clickLoginButton();
    }


}
