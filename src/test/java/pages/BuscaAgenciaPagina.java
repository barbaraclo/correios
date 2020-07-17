package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BuscaAgenciaPagina {

    private WebDriver driver;
    private WebDriverWait espera;
    private String urlAgencias = "http://www2.correios.com.br/sistemas/agencias/";
    private By localidade_seletor = By.cssSelector(".f2col:first-child input");
    private By estado_seletor = By.cssSelector("select[name='estadoAgencia']");
    private By municipio_seletor = By.cssSelector("select[name='municipioAgencia']");
    private By lista_municipio_seletor = By.cssSelector("option");
    private By selecionar_estado_seletor = By.cssSelector("option:first-child");
    private By estado_erro_seletor = By.className("estadoAgenciaformError");
    private By campo_obrigatorio_seletor = By.className("formErrorContent");

    public BuscaAgenciaPagina (WebDriver driver){
        this.driver = driver;
        this.espera = GerenciadorDriver.getEspera();
    }

    public void redirecionaAgencia(){
        espera.until(ExpectedConditions.urlToBe(urlAgencias));
    }
    public void selecionarLocalidade(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(localidade_seletor));
        driver.findElement(localidade_seletor).click();
    }
    public void getEstado(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(estado_seletor));
        driver.findElement(estado_seletor).click();
    }

    public void selecionarEstadoVazio(){
        getEstado();
        espera.until(ExpectedConditions.visibilityOfElementLocated(selecionar_estado_seletor));
        driver.findElement(selecionar_estado_seletor).click();
    }

    public WebElement getMunicipio(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(municipio_seletor));
        return driver.findElement(municipio_seletor);
    }

    public void selecionarMunicipio(){
        getMunicipio().click();
    }

    public int tamanhoListaMunicipio(){
        List<WebElement> municipios = getMunicipio().findElements(lista_municipio_seletor);
        return municipios.size();
    }

    public String messagemCampoObrigatorio(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(estado_erro_seletor));
        espera.until(ExpectedConditions.visibilityOfElementLocated(campo_obrigatorio_seletor));
        String mensagem_obrigatoria = driver.findElement(campo_obrigatorio_seletor).getText();

        return mensagem_obrigatoria;
    }




}
