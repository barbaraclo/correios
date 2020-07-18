package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RastrearObjetoMenu extends PaginaPrincipal{

    private By codigoRastreamento = By.id("objetos");
    private By botaoBusca = By.className("bt-link-ic");

    public RastrearObjetoMenu(WebDriver driver) {
        super(driver);
    }

    public void enviaCodigo(String codigo){
        espera.until(ExpectedConditions.visibilityOfElementLocated(codigoRastreamento));
        getRastreamento().findElement(codigoRastreamento).sendKeys(codigo);

    }
    public void clicaBotaoBusca(){
        espera.until(ExpectedConditions.visibilityOfElementLocated(botaoBusca));
        getRastreamento().findElement(botaoBusca).click();
    }

}
