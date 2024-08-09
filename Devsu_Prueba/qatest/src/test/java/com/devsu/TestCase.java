package com.devsu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        // Set up Extent Reports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testFlujodeCompra() {
     test = extent.createTest("testFlujodeCompra");
    try {
        loginPage.login("standard_user", "secret_sauce");
        test.info("Logged in with standard_user");
        
        productsPage.addProductsToCart();
        test.info("Added products to cart");
        
        productsPage.goToCart();
        cartPage.proceedToCheckout();
        test.info("Proceeded to checkout");
        
        checkoutPage.completePurchase("Pepito", "Perez", "111156");
        test.info("Completed purchase");

        try {
            WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"));
            if (confirmationMessage.isDisplayed()) {
                test.pass("Order confirmation message is displayed.");
            } else {
                test.fail("Order confirmation message is not displayed.");
            }
        } catch (Exception e) {
            test.fail("Order confirmation message is not displayed: " + e.getMessage());
        }
        
    } catch (Exception e) {
        test.fail("Test failed: " + e.getMessage());
    }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush(); // Save the report
    }
}
