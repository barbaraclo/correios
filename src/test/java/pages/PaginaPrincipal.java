package pages;

import manager.GerenciadorDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaPrincipal {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaginaPrincipal(WebDriver driver){

        this.driver = driver;
        this.wait = GerenciadorDriver.getWait();
    }
}
