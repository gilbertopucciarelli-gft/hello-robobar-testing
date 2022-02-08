package com.example.hellotestrobobar.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// http://localhost:3000/#!/
public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button")
    public WebElement addRoboColaButton;

    @FindBy(css = "html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(2) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button")
    public WebElement addRoboBeerButton;

    @FindBy(css = "html > body > robo-robobar > div > div:nth-of-type(2) > robo-place-order > div:nth-of-type(2) > table > tbody > tr:nth-of-type(3) > td:nth-of-type(3) > div > div > div:nth-of-type(2) > button")
    public WebElement addRobwineButton;

    @FindBy(css = "th[class='ng-binding']")
    public WebElement totalText;

    @FindBy(css = ".btn-success")
    public WebElement checkoutButton;

    public CheckoutPage checkout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}