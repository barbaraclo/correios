package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BuscaAgenciaPagina;
import pages.PaginaPrincipal;

public class BuscaAgenciaSteps {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal= new PaginaPrincipal(driver);
    private BuscaAgenciaPagina buscaAgencia = new BuscaAgenciaPagina(driver);

    @Dado("deseja realizar uma busca de agência")
    public void irParaBuscaAgencia() {
        paginaPrincipal.getAgenciaPagina();

    }

    @Quando("o usuário está na página de agências")
    public void paginaAgencia() {
       buscaAgencia.redirecionaAgencia();
    }

    @Quando("seleciona buscar agência por localidade")
    public void selecionaLocalidade() {
        buscaAgencia.selecionarLocalidade();
    }


    @Quando("deixa o campo Estado vazio")
    public void selecionaEstadoVazio() {
       buscaAgencia.selecionarEstadoVazio();
    }

    @Quando("seleciona o campo Município")
    public void selecionaMunicipio() {
        buscaAgencia.selecionarMunicipio();
    }

    @Entao("o campo Município retorna uma lista vazia")
    public void municipioVazio() {
        Assert.assertEquals(1,buscaAgencia.tamanhoListaMunicipio());
    }

    @Entao("uma mensagem {string} é mostrada na tela")
    public void campoObrigatorio(String mensagem) {
        Assert.assertEquals(buscaAgencia.messagemCampoObrigatorio(),mensagem);
    }
}
