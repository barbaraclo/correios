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
        String idioma = driver.findElement(idioma_seletor).getText();
     return idioma;
    }


    public WebElement getEndereco(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(busca_endereco_seletor));
        WebElement endereco = driver.findElement(busca_endereco_seletor);

     return endereco;
    }

    public WebDriver mudaAba(WebDriver driver){
        ArrayList<String> abas = new ArrayList<String> (driver.getWindowHandles());
        WebDriver aba = driver.switchTo().window(abas.get(1));
        System.out.println(driver.getTitle());

        return aba;
    }

}
