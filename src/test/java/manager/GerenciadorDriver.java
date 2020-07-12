package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorDriver {

    private static WebDriver driver;
    private static WebDriverWait espera;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
            driver = new ChromeDriver();
            // driver.manage().window().maximize();
        }
        return driver;
    }

    public static void finalizaSessao() {
        if (driver != null) {
            driver.quit();
            driver = null;
            espera = null;
        }
    }

    public static WebDriverWait getEspera() {
        if (espera == null) {
            espera = new WebDriverWait(getDriver(), 20);
        }
        return espera;
    }
}
