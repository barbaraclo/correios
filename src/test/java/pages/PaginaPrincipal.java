package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaPrincipal {

    /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait wait;
    private String paginaUrl = "https://www.correios.com.br";


    /*
     Page services
     */

    public PaginaPrincipal(WebDriver driver){

        this.driver = driver;
        this.wait = GerenciadorDriver.getWait();
    }

    public PaginaPrincipal acessarPagina() {
        driver.get(paginaUrl);
        return this;
    }

}
