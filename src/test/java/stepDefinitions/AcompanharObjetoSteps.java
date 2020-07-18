package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

public class AcompanharObjetoSteps {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal = new PaginaPrincipal(driver);
    private RastrearObjetoDefault rastrearObjetoDefault =  new RastrearObjetoDefault(driver);
    private MenuSuperior menuSuperior = new MenuSuperior(driver);
    private RastrearObjetoMenu rastrearObjetoMenu = new RastrearObjetoMenu(driver);
    private RastrearObjetoPreLogin rastrearObjetoPreLogin = new RastrearObjetoPreLogin(driver);
    private RastrearObjetoResultado rastrearObjetoResultado = new RastrearObjetoResultado(driver);

    @Dado("que o usuário está na página principal do site")
    public void paginaPrincipalSite() {
        paginaPrincipal.acessarPagina();

    }

    @Dado("deseja verificar o acompanhamento de um objeto")
    public void verificarAcompanhamentoObjeto() {
        paginaPrincipal.getRastreamento();
    }

    @Quando("o usuário procura o CPF {string}")
    public void buscaCPF(String cpf) {
        rastrearObjetoMenu.enviaCodigo(cpf);
        rastrearObjetoMenu.clicaBotaoBusca();
    }

    @Entao("o usuário é redirecionado para a página de resultado de rastreamento {string}")
    public void resultadoBusca(String pagina) {
        paginaPrincipal.mudaAba(driver);
        if (pagina.equals("pré-login")) {
            String retorno = rastrearObjetoPreLogin.obterUrl();
            Assert.assertEquals(retorno,driver.getCurrentUrl());
        } else if (pagina.equals("default")) {
            String retorno = rastrearObjetoDefault.obterUrl();
            Assert.assertEquals(retorno,driver.getCurrentUrl());
        } else if (pagina.equals("resultado")) {
            String retorno = rastrearObjetoResultado.obterUrl();
            Assert.assertEquals(retorno,driver.getCurrentUrl());
        } else {
            System.out.println("Pagina desconhecida");
        }
    }

    @Entao("é exibida a mensagem {string}")
    public void visualizaMensagem(String msgEsperada) {
        Assert.assertEquals(rastrearObjetoPreLogin.validaMensagem(),msgEsperada);
    }

    @Entao("a mensagem de erro {string} é mostrada ao usuário")
    public void mensagemErroEmRastrear(String msgEsperada) {
        Assert.assertEquals(rastrearObjetoDefault.msgErro(),msgEsperada);
    }

    @Entao("o botão cadastre-se é visualizado")
    public void validaBotao() {
        rastrearObjetoPreLogin.validaBotao();
    }

    @Quando("o usuário procura código {string}")
    public void buscaCodigo(String codigo) {
        rastrearObjetoMenu.enviaCodigo(codigo);
        rastrearObjetoMenu.clicaBotaoBusca();
    }

    @Entao("o sistema exibe as informações de rastreamento do objeto {string}")
    public void validaCodigoRastreamento(String codigoRastreamento) {
        Assert.assertEquals(rastrearObjetoResultado.validaCodigo(),codigoRastreamento);
    }

    @Dado("que o usuário está na página de rastreamento")
    public void acessaPaginaRastreamento() {
        paginaPrincipal.acessarPagina();
        menuSuperior.expandirMenu();
        menuSuperior.acessarPaginaRastreamento();

    }

    @Quando("o usuário clica em buscar")
    public void clicaBuscarEmRastrear() {
        rastrearObjetoDefault.clicarBuscar();
    }

    @Entao("a mensagem de alerta {string} é mostrada ao usuário")
    public void mensagemAlertaEmRastrear(String msgEsperada) {
        String msgAtual = rastrearObjetoDefault.msgAlerta();
        Assert.assertEquals("Mensagem ao usuário é " + msgEsperada, msgEsperada, msgAtual);
    }

    @Entao("a mensagem de informação {string} é mostrada ao usuário")
    public void mensagemInformaEmRastrear(String msgEsperada) {
        String msgAtual = rastrearObjetoDefault.msgInfo();
        Assert.assertEquals("Mensagem ao usuário é " + msgEsperada, msgEsperada, msgAtual);
    }

    @Quando("o usuário procura os objetos: {string}")
    public void procuraObjetos(String codigo) {
        rastrearObjetoDefault.enviarCodigos(codigo);
    }

}