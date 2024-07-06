package com.nttdata.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import com.nttdata.screens.SauceLabsScreen;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SauceLabsSteps extends ScenarioSteps {

    private SauceLabsScreen sauceLabsScreen;

    public SauceLabsSteps() {
        Serenity AppiumDriverProvider = null;
        WebDriver driver = AppiumDriverProvider.getDriver();
        sauceLabsScreen = new SauceLabsScreen(driver);
    }

    @Step("Abrir la aplicación de SauceLabs")
    public void openApp() {
    }

    @Step("Verificar que la aplicación se ha cargado correctamente")
    public void verifyAppLoaded() {
        boolean isLoaded = sauceLabsScreen.isProductTitleDisplayed();
        Assert.assertTrue("La aplicación no se ha cargado correctamente", isLoaded);
    }

    @Step("Agregar {0} del producto {1} al carrito")
    public void addProductToCart(String producto, int unidades) {
        sauceLabsScreen.selectProduct(producto);
        sauceLabsScreen.addUnitsToCart(unidades);
    }

    @Step("Verificar que el carrito se ha actualizado correctamente")
    public void verifyCartUpdated() {
        boolean isCartUpdated = sauceLabsScreen.isCartUpdated();
        Assert.assertTrue("El carrito no se ha actualizado correctamente", isCartUpdated);
    }
}

