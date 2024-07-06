package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SauceLabsSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class SauceLabsStepDef {

    @Steps
    SauceLabsSteps sauceLabsSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void givenTheAppIsOpen() {
        sauceLabsSteps.openApp();
    }

    @And("valido que carguen correctamente los productos en la galería")
    public void andValidateProductsLoaded() {
        sauceLabsSteps.verifyAppLoaded();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void whenIAddProduct(int unidades, String producto) {
        sauceLabsSteps.addProductToCart(producto, unidades);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void thenValidateCartUpdated() {
        sauceLabsSteps.verifyCartUpdated();
    }
}

