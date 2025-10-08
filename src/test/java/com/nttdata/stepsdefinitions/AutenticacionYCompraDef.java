package com.nttdata.stepsdefinitions;



import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.CategoriaProductosSteps;
import com.nttdata.steps.LoginStoreSteps;
import com.nttdata.steps.ProductosSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;


import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class AutenticacionYCompraDef {

    private WebDriver driver;


    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        screenShot();

    }

    @Y("me logueo con mi usuario: {string} y contraseña: {string}")
    public void meLogueoConMiUsuarioYContraseña(String usuario, String contrasena) {
        LoginStoreSteps loginStoreSteps = new LoginStoreSteps(driver);
        loginStoreSteps.abrirPantallaLogin();
        screenShot();
        loginStoreSteps.typeUsuario(usuario);
        loginStoreSteps.typecontrasena(contrasena);
        loginStoreSteps.loginButton();

        screenShot();

    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaClothesYSubcategoriaMen(String categoria, String subcategoria) {
        CategoriaProductosSteps categoriaProductosSteps = new CategoriaProductosSteps(driver);
        categoriaProductosSteps.seleccionarCategoria(categoria);
        screenShot();
        categoriaProductosSteps.seleccionarSubcategoria(subcategoria);
        screenShot();

    }

    @Y("agrego {int} del primer producto al carrito")
    public void agregoDelPrimerProductoAlCarrito(int quantity) {

        ProductosSteps productosSteps = new ProductosSteps(driver);
        productosSteps.selectProduct();
        screenShot();
        productosSteps.selectQuantity(quantity);
        screenShot();
        productosSteps.CartButton();


    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        ProductosSteps productosSteps = new ProductosSteps(driver);
        productosSteps.popup();
        screenShot();

    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        ProductosSteps productosSteps = new ProductosSteps(driver);
        productosSteps.validarMontoTotalPopup();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        ProductosSteps productosSteps = new ProductosSteps(driver);
        productosSteps.finalizarCompra();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CarritoSteps carritoSteps = new CarritoSteps(driver);
        carritoSteps.validarTituloCarrito();
        screenShot();

    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {

        CarritoSteps carritoSteps = new CarritoSteps(driver);
        carritoSteps.validarMontoTotalEnCarrito();
        screenShot();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
