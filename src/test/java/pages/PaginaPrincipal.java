package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaginaPrincipal {

    /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait espera;
    private String paginaUrl = "https://www.correios.com.br";
    private By idioma_seletor = By.cssSelector(".bt-idioma span");

    /*
     Page services
     */

    public PaginaPrincipal(WebDriver driver){

        this.driver = driver;
        this.espera = GerenciadorDriver.getEspera();
    }

    public PaginaPrincipal acessarPagina() {
        driver.get(paginaUrl);
        return this;
    }

    public String checarIdioma(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(idioma_seletor));
        String idioma = driver.findElement(idioma_seletor).getText();
        System.out.println(idioma);
     return idioma;
    }

}
