package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class PaginaPrincipal {

    /*
     Page representation
     */

    protected WebDriver driver;
    protected WebDriverWait espera;
    private By idioma_seletor = By.cssSelector(".bt-idioma span");
    private By busca_endereco_seletor = By.cssSelector(".mais-acessados form:nth-child(2)");
    private By busca_agencia_seletor = By.cssSelector(".show-mais-acessados:nth-child(5)");
    private By busca_agencia_botao_seletor = By.className("bt");

    /*
     Page services
     */

    public PaginaPrincipal(WebDriver driver){

        this.driver = driver;
        this.espera = GerenciadorDriver.getEspera();
    }

    public PaginaPrincipal acessarPagina() {
        driver.get(URL.MAIN_PAGE);
        return this;
    }


    public String checarIdioma(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(idioma_seletor));
        String idioma_atual = driver.findElement(idioma_seletor).getText();
     return idioma_atual;
    }


    public WebElement getEndereco(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(busca_endereco_seletor));
        WebElement caixa_endereco = driver.findElement(busca_endereco_seletor);

     return caixa_endereco;
    }

    public WebDriver mudaAba(WebDriver driver){
        ArrayList<String> abas = new ArrayList<String> (driver.getWindowHandles());
        WebDriver aba_atual = driver.switchTo().window(abas.get(1)); // muda o driver para a aba nova que foi aberta

        return aba_atual;
    }
    public void getAgenciaPagina(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(busca_agencia_seletor));
        WebElement caixa_agencia = driver.findElement(busca_agencia_seletor);
        espera.until(ExpectedConditions.visibilityOfElementLocated(busca_agencia_botao_seletor));
        caixa_agencia.findElement(busca_agencia_botao_seletor).click();
    }

}
