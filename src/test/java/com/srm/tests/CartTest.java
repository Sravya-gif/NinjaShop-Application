package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);
        pp.searchProduct("iphone");
        pp.selectFirstProduct();

        int beforeCount = cp.getCartCount();
        System.out.println("Before Count: " + beforeCount);
        cp.addToCart();

        int afterCount = cp.getCartCount();
        System.out.println("After Count: " + afterCount);
        boolean result = afterCount > beforeCount;

        Assert.assertTrue(result);
    }

    @Test
    public void updateCartTest() {

        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);

        pp.searchProduct("iphone");
        pp.selectFirstProduct();
        cp.addToCart();
        cp.openCart();
        cp.updateQuantity("3");

        boolean result = cp.isUpdateSuccessDisplayed();

        Assert.assertTrue(result);
    }

    @Test
    public void removeCartTest() {

        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);
        pp.searchProduct("iphone");
        pp.selectFirstProduct();
        cp.addToCart();
        int beforeCount = cp.getCartCount();
        System.out.println("Before Count: " + beforeCount);
        
        cp.openCart();
        cp.removeProduct();

        int afterCount = cp.getCartCount();
        System.out.println("After Count: " + afterCount);
        boolean result = afterCount < beforeCount;

        Assert.assertTrue(result);
    }
}