package com.example.hellotestrobobar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://localhost:3000/#!/review
public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ageInput")
    public WebElement ageInput;

    @FindBy(css = ".btn-success")
    public WebElement orderButton;

    public OrderPage orderPage() {
        orderButton.click();
        return new OrderPage(driver);
    }
}