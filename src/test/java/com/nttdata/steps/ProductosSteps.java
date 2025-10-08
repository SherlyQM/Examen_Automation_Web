package com.nttdata.steps;


import com.nttdata.page.ProductosPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductosSteps {

    private WebDriver driver;

    public ProductosSteps(WebDriver driver){ this.driver=driver;}

    public void selectProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(ProductosPage.firstProduct));
        driver.findElement(ProductosPage.firstProduct).click();
    }

    public void selectQuantity(int quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        for(int i=1; i < quantity; i++){
            driver.findElement(ProductosPage.quantity).click();
        }
    }

    public void CartButton(){
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(ProductosPage.CartButton).click();
    }

    public void popup(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(ProductosPage.popup));

    }
    public void validarMontoTotalPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductosPage.popup));

        String unitPriceText = driver.findElement(ProductosPage.popupUnitPrice).getText();
        String precioLimpio = unitPriceText.replace("S/", "").trim();
        double precioUnitario = Double.parseDouble(precioLimpio);

        String cantidadText = driver.findElement(ProductosPage.popupQuantity).getText();
        String cantidadLimpia = cantidadText.replace("Cantidad:", "").trim();
        int cantidad = Integer.parseInt(cantidadLimpia);

        String totalText = driver.findElement(ProductosPage.popupTotal).getText();
        String[] lineas = totalText.split("\n");
        String totalLinea = lineas[lineas.length - 1];
        String totalLimpio = totalLinea.replace("S/", "").trim();
        double totalMostrado = Double.parseDouble(totalLimpio);

        double totalEsperado = Math.round(precioUnitario * cantidad * 100.0) / 100.0;

        if (totalMostrado != totalEsperado) {
            throw new AssertionError("Total incorrecto en popup. Esperado: S/ " + totalEsperado + " - Mostrado: S/ " + totalMostrado);
        } else {
            System.out.println("Total correcto en popup: S/ " + totalMostrado);
        }

    }

    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ProductosPage.finalizarCompraBtn)).click();
    }



}
