package com.example.hellotestrobobar.pageobject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CartSuiteTest {

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
    public void onexRoboCola() {
        cartPage.addRoboColaButton.click();
        assertEquals(cartPage.totalText.getText(), "€1.25");
    }

    @Test
    public void onexRoboBeer() {
        cartPage.addRoboBeerButton.click();
        assertEquals(cartPage.totalText.getText(), "€2.00");
    }

    @Test
    public void onexRobwine() {
        cartPage.addRobwineButton.click();
        assertEquals(cartPage.totalText.getText(), "€3.00");
    }

    @Test
    public void onexRoboCola1xRoboBeer() {
        cartPage.addRoboColaButton.click();
        cartPage.addRoboBeerButton.click();
        assertEquals(cartPage.totalText.getText(), "€3.25");
    }

    @Test
    public void onexRoboCola1xRoboBeer1xRobwine() {
        cartPage.addRoboColaButton.click();
        cartPage.addRoboBeerButton.click();
        cartPage.addRobwineButton.click();
        assertEquals(cartPage.totalText.getText(), "€6.25");
    }

    @Test
    public void twoxRobwine() {
        cartPage.addRobwineButton.click();
        cartPage.addRobwineButton.click();
        assertEquals(cartPage.totalText.getText(), "€6.00");
    }

    @Test
    public void twoxRoboBeer() {
        cartPage.addRoboBeerButton.click();
        cartPage.addRoboBeerButton.click();
        assertEquals(cartPage.totalText.getText(), "€4.00");
    }

    @Test
    public void twoxRoboCola() {
        cartPage.addRoboColaButton.click();
        cartPage.addRoboColaButton.click();
        assertEquals(cartPage.totalText.getText(), "€2.50");
    }
}
