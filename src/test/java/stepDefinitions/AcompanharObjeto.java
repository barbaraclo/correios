package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MenuSuperior;
import pages.PaginaPrincipal;
import pages.RastrearObjeto;

public class AcompanharObjeto {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal;
    private RastrearObjeto rastrearObjeto;
    private MenuSuperior menuSuperior;

    @Dado("que o usuário está na página principal do site")
    public void paginaPrincipalSite() {
        paginaPrincipal = new PaginaPrincipal(driver);
        paginaPrincipal.acessarPagina();

    }

    @Dado("deseja verificar o acompanhamento de um objeto")
    public void verificarAcompanhamentoObjeto() {
    }

    @Quando("o usuário procura o CPF {string}")
    public void buscaCPF(String string) {
    }

    @Quando("não está logado")
    public void usuarioNaoLogado() {
    }

    @Entao("o usuário é redirecionado para a página de resultado de rastreamento")
    public void resultadoBusca() {
    }

    @Entao("o botão cadastre-se é visualizado")
    public void validaBotao() {
    }

    @Quando("o usuário procura código {string}")
    public void buscaCodigo(String string) {
    }

    @Entao("o sistema exibe as informações de rastreamento do objeto")
    public void validaInformacoesObjeto() {
    }

    @Dado("que o usuário está na página de rastreamento")
    public void acessaPaginaRastreamento() {
        paginaPrincipal = new PaginaPrincipal(driver);
        menuSuperior = new MenuSuperior(driver);
        paginaPrincipal.acessarPagina();
        menuSuperior.expandirMenu();
        menuSuperior.acessarPaginaRastreamento();

    }

    @Quando("o usuário clica em buscar")
    public void clicaBuscarEmRastrear() {
        rastrearObjeto = new RastrearObjeto(driver);
        rastrearObjeto.clicarBuscar();
    }

    @Entao("a mensagem de alerta {string} é mostrada ao usuário")
    public void mensagemAlertaEmRastrear(String msgEsperada) {
        rastrearObjeto = new RastrearObjeto(driver);
        String msgAtual = rastrearObjeto.msgAlerta();
        Assert.assertEquals("Mensagem ao usuário é " + msgEsperada, msgEsperada, msgAtual);
    }

    @Entao("a mensagem de informação {string} é mostrada ao usuário")
    public void mensagemInformaEmRastrear(String msgEsperada) {
        rastrearObjeto = new RastrearObjeto(driver);
        String msgAtual = rastrearObjeto.msgInfo();
        Assert.assertEquals("Mensagem ao usuário é " + msgEsperada, msgEsperada, msgAtual);
    }

    @Quando("o usuário procura os objetos: {string}")
    public void procuraObjetos(String codigo) {
        rastrearObjeto = new RastrearObjeto(driver);
        rastrearObjeto.enviarCodigos(codigo);
    }

}

