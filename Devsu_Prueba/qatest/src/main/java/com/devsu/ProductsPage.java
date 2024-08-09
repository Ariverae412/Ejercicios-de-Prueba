package com.devsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By addToCartButton1 = By.id("add-to-cart-sauce-labs-backpack");
    private By addToCartButton2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductsToCart() {
        driver.findElement(addToCartButton1).click();
        driver.findElement(addToCartButton2).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
