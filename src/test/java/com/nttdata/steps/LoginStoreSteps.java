package com.nttdata.steps;

import com.nttdata.page.LoginStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStoreSteps {


    private WebDriver driver;

    //constructor
    public LoginStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void abrirPantallaLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(LoginStorePage.btnIniciarSesion)).click();
    }

    /**
     * Escribir el usuario
     * @param usuario el usuario
     */
    public void typeUsuario(String usuario){
        WebElement userInputElement = driver.findElement(LoginStorePage.userInput);
        userInputElement.sendKeys(usuario);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginStorePage.loginButton));


    }

    /**
     * Escribir el password
     * @param contrasena el password del contrasena
     */
    public void typecontrasena(String contrasena){
        this.driver.findElement(LoginStorePage.passInput).sendKeys(contrasena);
    }

    /**
     * Hacer click en el botón login
     */
    public void loginButton(){
        this.driver.findElement(LoginStorePage.loginButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginStorePage.cerrarsesionButton));
            System.out.println("Login exitoso, existe el boton cerrar sesión.");
        } catch (Exception e) {
            System.out.println("Cerrar sesión no existe, el login ha fallado.");
            throw new AssertionError("Login fallido, no existe el boton cerrar sesión.");
        }
    }
}
