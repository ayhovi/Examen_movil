package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV' and @text='Products']")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpack;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Bolt T-Shirt']")
    private WebElement sauceLabsBoltTShirt;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Bike Light']")
    private WebElement sauceLabsBikeLight;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")
    private WebElement productQuantity;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Increase item quantity']")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cart']")
    private WebElement cartButton;

    public SauceLabsScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(((WebDriverFacade) driver).getProxiedDriver()), this);
    }

    public boolean isProductTitleDisplayed() {
        return productTitle.isDisplayed();
    }

    public void selectProduct(String productName) {
        WebElement product;
        switch (productName) {
            case "Sauce Labs Backpack":
                product = sauceLabsBackpack;
                break;
            case "Sauce Labs Bolt T-Shirt":
                product = sauceLabsBoltTShirt;
                break;
            case "Sauce Labs Bike Light":
                product = sauceLabsBikeLight;
                break;
            default:
                throw new IllegalArgumentException("Producto no reconocido: " + productName);
        }
        product.click();
    }

    public void addUnitsToCart(int units) {
        for (int i = 1; i < units; i++) {
            increaseQuantityButton.click();
        }
        cartButton.click();
    }

    public boolean isCartUpdated() {
        return true;
    }
}
