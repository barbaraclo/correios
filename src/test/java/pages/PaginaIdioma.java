package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;

public class PaginaIdioma extends PaginaPrincipal{

    private By selecionar_idioma_seletor = By.cssSelector(".ic-marcador-out");
    private By seleciona_portugues_seletor = By.className("language-pt-br");


    public PaginaIdioma(WebDriver driver){
        super(driver);
    }

    public void setIdioma (){
        String idioma = checarIdioma();
        boolean portugues = idioma.equals("Português");
        if (!portugues){
            mudarPortugues();
        }
    }
    public void mudarPortugues(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(selecionar_idioma_seletor));
        driver.findElement(selecionar_idioma_seletor).click();

        espera.until(ExpectedConditions.visibilityOfElementLocated(seleciona_portugues_seletor));
        driver.findElement(seleciona_portugues_seletor).click();


    }
}
