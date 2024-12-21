package com.nttdata.steps;

import com.nttdata.screens.CantidadCarritoScreen;
import com.nttdata.screens.CarritoScreen;
import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;

public class LoginSteps {
    ProductsScreen productsScreen;
    CarritoScreen carritoScreen;
    CantidadCarritoScreen cantidadCarritoScreen;

    public void loginSuccess() {
        Assert.assertTrue("No se mostró el título del producto", productsScreen.isProductDisplayed());
    }

    public void cargaCorrecta() {
        Assert.assertTrue("No se mostró el  producto", productsScreen.isCatalogoDisplayed());

    }

    public void agregarCarrito(int cant, String producto) {
        productsScreen.clickOnProducto(producto);
        carritoScreen.enterCantidad(cant);
        carritoScreen.agregarCarrito();

    }

    public void validarCarrito(int numero) {
        carritoScreen.irCarrito();
        cantidadCarritoScreen.validarCarrito(numero);

    }
}
