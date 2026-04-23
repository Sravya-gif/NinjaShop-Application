package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductPage;

public class ProductTest extends BaseTest {

    @Test
    public void searchProductTest() {

        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("iphone");
        boolean result = driver.getPageSource().contains("iPhone");

        Assert.assertTrue(result);
    }

    @Test
    public void productDetailTest() {

        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("iphone");
        pp.selectFirstProduct();

        String name = pp.getProductName();
        String price = pp.getProductPrice();
        boolean result = name.length() > 0 && price.length() > 0;

        Assert.assertTrue(result);
    }

    @Test
    public void noResultTest() {

        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("xyz123");
        boolean result = pp.isNoResultDisplayed();

        Assert.assertTrue(result);
    }
}