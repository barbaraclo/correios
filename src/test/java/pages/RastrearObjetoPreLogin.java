package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RastrearObjetoPreLogin {

    private WebDriver driver;
    private WebDriverWait espera;
    private String url = "https://www2.correios.com.br/sistemas/rastreamento/preLogin.cfm";
    private By mensagemSeletor = By.cssSelector("#login h3");
    private By botaoSeletor = By.id("modalSms");

    public RastrearObjetoPreLogin(WebDriver driver){
        this.driver = driver;
        this.espera = GerenciadorDriver.getEspera();
    }

    public String obterUrl(){
        espera.until(ExpectedConditions.urlToBe(url));
        return url;
    }

    public String validaMensagem(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(mensagemSeletor));
        return driver.findElement(mensagemSeletor).getText();
    }

    public void validaBotao(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(botaoSeletor));
    }


}
