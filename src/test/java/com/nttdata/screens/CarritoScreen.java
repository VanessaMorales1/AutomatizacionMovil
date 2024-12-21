package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarritoScreen extends PageObject {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement cant;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAgregar;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement irCarrito;


    public void enterCantidad(int cantidad) {
        waitFor(ExpectedConditions.visibilityOf(cant)); // Asegúrate de que el botón sea visible.
        for (int i = 1; i < cantidad; i++) {
            cant.click(); // Haz clic en el botón.
        }
    }

    public void agregarCarrito() {
        waitFor(ExpectedConditions.visibilityOf(btnAgregar)); // Asegúrate de que el botón sea visible.
        btnAgregar.click();
    }

    public void irCarrito() {
        waitFor(ExpectedConditions.visibilityOf(irCarrito));
        irCarrito.click();
    }
}




