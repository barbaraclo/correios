package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultadoEnderecoPagina {

    private WebDriver driver;
    private WebDriverWait espera;
    private String urlResultado = "http://www.buscacep.correios.com.br/sistemas/buscacep/resultadoBuscaCepEndereco.cfm?t";
    private By mensagem_seletor = By.cssSelector(".ctrlcontent p");
    private By tabela_seletor = By.className("tmptabela");
    private By tabela_linha_seletor = By.cssSelector("tr");
    private By coluna_cep_seletor = By.cssSelector("tr:last-child");
    private By cep_seletor = By.cssSelector("td:last-child");
    private By logradouro_seletor = By.cssSelector("td:first-child");


    public ResultadoEnderecoPagina(WebDriver driver){
        this.driver = driver;
        espera = GerenciadorDriver.getEspera();
    }

    public String getUrlResultado(){
        espera.until(ExpectedConditions.urlToBe(urlResultado));
        return urlResultado;
    }

    public String validaMensagem (){
        espera.until(ExpectedConditions.visibilityOfElementLocated(mensagem_seletor));
        return driver.findElement(mensagem_seletor).getText();
    }
    public String validaCep (){
        espera.until(ExpectedConditions.visibilityOfElementLocated(tabela_seletor));
        WebElement cep = getTabela().findElement(cep_seletor);
        return cep.getText();
    }
    public boolean validaTabelaCep(String cep){
        boolean cep_igual = false;

        List<WebElement> linhas = getTabela().findElements(tabela_linha_seletor);
        for (int i =1 ; i< linhas.size();i++){
            String cep_valor = linhas.get(i).findElement(cep_seletor).getText();
            cep_igual = cep_valor.contains(cep.substring(0,5)+"-"+cep.substring(6)); // valida o resultado que contém no site, utilizando o '-'
        }
        return cep_igual;

    }

    public WebElement getTabela(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(tabela_seletor));
        WebElement tabela_endereco = driver.findElement(tabela_seletor);
        return tabela_endereco;
    }

    public boolean validaLogradouro (String log){
        boolean contemLogradouro = false;

        espera.until(ExpectedConditions.visibilityOfElementLocated(tabela_seletor));
        WebElement logradouro = getTabela().findElement(logradouro_seletor);

        contemLogradouro = logradouro.getText().contains(log);

        return contemLogradouro;

    }



}
