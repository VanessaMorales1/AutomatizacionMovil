package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CantidadCarritoScreen extends PageObject {
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")
    private WebElement cantCarrito;

    public void validarCarrito(int numero) {
        waitFor(ExpectedConditions.visibilityOf(cantCarrito)); // Espera a que el elemento sea visible.
        cantCarrito.getText();
        String textoCarrito = cantCarrito.getText().replace(" Items", ""); // Elimina " Items" del texto.
        int cantidadActual = Integer.parseInt(textoCarrito);
        Assert.assertEquals(numero, cantidadActual);

    }
}
