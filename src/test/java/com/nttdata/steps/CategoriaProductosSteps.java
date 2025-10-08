package com.nttdata.steps;

import com.nttdata.page.CategoriaProductosPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoriaProductosSteps {

    private WebDriver driver;

    //constructor
    public CategoriaProductosSteps(WebDriver driver){
        this.driver = driver;
    }

    public void seleccionarCategoria(String categoria){
        if (categoria.equalsIgnoreCase("Clothes")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(CategoriaProductosPage.categoryPage));
            driver.findElement(CategoriaProductosPage.categoryPage).click();
        } else {
            System.out.println("Categoría no encontrada: " + categoria);
        }
    }

    public void seleccionarSubcategoria(String subcategoria){
        if (subcategoria.equalsIgnoreCase("Men")) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(CategoriaProductosPage.productsMen));
            driver.findElement(CategoriaProductosPage.productsMen).click();
        } else {
            System.out.println("Subcategoría no encontrada: " + subcategoria);
        }
    }


}
