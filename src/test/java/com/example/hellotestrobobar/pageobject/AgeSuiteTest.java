package com.example.hellotestrobobar.pageobject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AgeSuiteTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    CartPage cartPage;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @BeforeEach
    public void setupTest() {
        cartPage = new CartPage(driver);
        driver.get("http://localhost:3000/");
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void onexRoboBeerCheckoutGreater18() {
        cartPage.addRoboBeerButton.click();
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.ageInput.click();
        checkoutPage.ageInput.sendKeys("21");
        OrderPage orderPage = checkoutPage.orderPage();
        assertEquals(orderPage.confirmationMessage.getText(), "Coming right up! ~bzzzt~");
    }

    @Test
    public void onexRoboBeerCheckoutLess18() {
        cartPage.addRoboBeerButton.click();
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.ageInput.click();
        checkoutPage.ageInput.sendKeys("17");
        OrderPage orderPage = checkoutPage.orderPage();
        assertEquals(orderPage.alertMessage.getText(), "Only adults can buy alcohol!");
    }

    @Test
    public void onexRoboColaCheckout() {
        cartPage.addRoboColaButton.click();
        CheckoutPage checkoutPage = cartPage.checkout();
        OrderPage orderPage = checkoutPage.orderPage();
        assertEquals(orderPage.confirmationMessage.getText(), "Coming right up! ~bzzzt~");
    }
}
