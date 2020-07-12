package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscaEnderecoPagina extends PaginaPrincipal{

    private By campo_entrada_seletor = By.id("acesso-busca");
    private By busca_seletor = By.className("bt-link-ic");


    public BuscaEnderecoPagina (WebDriver driver){
        super(driver);

    }
    public void enviaEndereco(String palavras){
        espera.until(ExpectedConditions.visibilityOfElementLocated(campo_entrada_seletor));
        getEndereco().findElement(campo_entrada_seletor).sendKeys(palavras);

    }
    public void clicaBusca(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(busca_seletor));
        getEndereco().findElement(busca_seletor).click();
    }



}
