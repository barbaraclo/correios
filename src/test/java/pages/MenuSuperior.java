package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuSuperior {

    /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait wait;
    private By expandeMenu = By.cssSelector(".ic-marcador-out.rotacao-90");
    private By menuProdutosServicos = By.cssSelector(".menu-superior");
    private By linkRastreamento = By.cssSelector(".menu-home-a-2:nth-child(2) .menu-lista-2:nth-child(4) .menu-lista-3");

    public MenuSuperior(WebDriver driver) {
        this.driver = driver;
        this.wait = GerenciadorDriver.getEspera();
    }

    public void expandirMenu() {
        driver.findElement(expandeMenu).click();
    }

    public void acessarPaginaRastreamento() {
        encontrarLink(linkRastreamento).click();
        wait.until(ExpectedConditions.urlToBe("https://www2.correios.com.br/sistemas/rastreamento/"));
    }

    private WebElement encontrarLink(By btnSelector) {
        WebElement navMenu = driver.findElement(menuProdutosServicos);
        return navMenu.findElement(btnSelector);
    }

}
