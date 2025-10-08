package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoSteps {

    private WebDriver driver;

    public CarritoSteps(WebDriver driver){ this.driver=driver;}

    public void validarTituloCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.popupcarrito));

    }

    public void validarMontoTotalEnCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement precioUnitarioElem = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.carritoUnitPrice));
        String precioUnitarioTexto = precioUnitarioElem.getText().replace("S/", "").trim();
        double precioUnitario = Double.parseDouble(precioUnitarioTexto);

        WebElement cantidadElem = driver.findElement(CarritoPage.carritoCantidad);
        int cantidad = Integer.parseInt(cantidadElem.getAttribute("value").trim());

        WebElement totalElem = driver.findElement(CarritoPage.carritoTotal);
        String totalTexto = totalElem.getText();

        String[] lineas = totalTexto.split("\n");
        String totalLinea = lineas[lineas.length - 1];
        String totalLimpio = totalLinea.replace("S/", "").trim();
        double totalMostrado = Double.parseDouble(totalLimpio);

        double totalEsperado = Math.round(precioUnitario * cantidad * 100.0) / 100.0;

        if (totalMostrado != totalEsperado) {
            throw new AssertionError("Total incorrecto en carrito. Esperado: S/ " + totalEsperado + " - Mostrado: S/ " + totalMostrado);
        } else {
            System.out.println("Total correcto en carrito: S/ " + totalMostrado);
        }
    }



}
