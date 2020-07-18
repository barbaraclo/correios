package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RastrearObjetoDefault {
     /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait wait;
    private By botaoBuscar = By.id("btnPesq");
    private By msgInfo = By.cssSelector(".info.information");
    private By msgAlert = By.cssSelector(".info.alert");
    private By campoObjetos = By.id("objetos");
    private String url = "https://www2.correios.com.br/sistemas/rastreamento/default.cfm";
    private By msgErro = By.cssSelector(".info.error");

    /*
     Page services
     */

    public RastrearObjetoDefault(WebDriver driver){
        this.driver = driver;
        this.wait = GerenciadorDriver.getEspera();
    }

    public void clicarBuscar() {
        driver.findElement(botaoBuscar).click();
    }

    public void enviarCodigos(String codigos) {
        driver.findElement(campoObjetos).sendKeys(codigos);
    }

    public String msgAlerta() {
        WebElement msg = driver.findElement(msgAlert);
        wait.until(ExpectedConditions.visibilityOf(msg));
        return msg.getText();
    }

    public String msgInfo() {
        WebElement msg = driver.findElement(msgInfo);
        wait.until(ExpectedConditions.visibilityOf(msg));
        return msg.getText();
    }

    public String obterUrl(){
        wait.until(ExpectedConditions.urlToBe(url));
        return url;
    }

    public String msgErro() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgErro));
        return driver.findElement(msgErro).getText();
    }


}
