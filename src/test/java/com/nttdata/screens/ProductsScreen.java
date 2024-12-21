package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement lblProduct;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Fleece Jacket\"]")
    private WebElement catalogoProduct;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Fleece Jacket\"]")
    private WebElement clicImgProd;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc]")
    private List<WebElement> productos;

    public boolean isProductDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(lblProduct));
        return lblProduct.isEnabled();
    }

    public boolean isCatalogoDisplayed() {
        try {
            waitFor(ExpectedConditions.visibilityOf(catalogoProduct));
            if (!catalogoProduct.isEnabled()) {
                System.out.println("El catálogo no está habilitado.");
                return false;
            }
            if (productos.isEmpty()) {
                System.out.println("El catálogo está vacío, no hay productos visibles.");
                return false;
            }

            for (WebElement producto : productos) {
                if (!producto.isDisplayed()) {
                    System.out.println("Producto no visible: " + producto.getText());
                    return false;
                }
            }

            System.out.println("Todos los productos del catálogo están cargados correctamente.");
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error al verificar el catálogo: " + e.getMessage());
            return false;
        }
    }

    public void clickOnProducto(String nombreProducto) {
        for (WebElement producto : productos) {
            if (producto.getAttribute("content-desc").equals(nombreProducto)) {
                System.out.println(producto.getAttribute("content-desc"));
                producto.click();
                System.out.println("Producto encontrado: " + nombreProducto);
                return;
            }
        }
        throw new RuntimeException("No se encontró el producto: " + nombreProducto);

    }


}

















