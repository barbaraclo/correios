package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.GerenciadorDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PaginaIdioma;
import pages.PaginaPrincipal;

public class Hoocks {

    private WebDriverWait espera = GerenciadorDriver.getEspera();
    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaIdioma paginaIdioma;


    @Before
    public void antesScenario(){
        paginaIdioma = new PaginaIdioma(driver);
        paginaIdioma.acessarPagina();
        paginaIdioma.setIdioma(); // iniciar sempre o site com o idioma português
    }

    @After
    public void finalizarSessao(){
        GerenciadorDriver.finalizaSessao();
    }
}
