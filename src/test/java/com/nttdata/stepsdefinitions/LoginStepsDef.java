package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginStepsDef {
    @Steps
    LoginSteps loginSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {
        loginSteps.loginSuccess();
    }

    @Given("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        loginSteps.cargaCorrecta();
    }

    @When("agrego {} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int cant, String producto) {
        loginSteps.agregarCarrito(cant, producto);

    }

    @Then("valido el carrito de compra actualice correctamente con la cantidad {int}")
    public void validoElCarritoDeCompraActualiceCorrectamenteConLaCantidad(int numero) {
        loginSteps.validarCarrito(numero);
    }
}
