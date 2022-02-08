package com.example.hellotestrobobar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://localhost:3000/#!/review
public class OrderPage {

    private final WebDriver driver;

    @FindBy(css = "p")
    public WebElement confirmationMessage;

    @FindBy(css = "p")
    public WebElement alertMessage;
    
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}