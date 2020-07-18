package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RastrearObjetoResultado {

    private WebDriver driver;
    private WebDriverWait espera;
    private String url = "https://www2.correios.com.br/sistemas/rastreamento/resultado.cfm";
    private By cdRastreamentoSeletor = By.className("codSro");

    public RastrearObjetoResultado(WebDriver driver){
        this.driver = driver;
        this.espera = GerenciadorDriver.getEspera();
    }

    public String obterUrl(){
        espera.until(ExpectedConditions.urlToBe(url));
        return url;
    }

    public String validaCodigo(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(cdRastreamentoSeletor));
        return driver.findElement(cdRastreamentoSeletor).getText();
    }

}
