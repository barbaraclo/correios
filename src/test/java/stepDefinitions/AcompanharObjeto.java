package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.openqa.selenium.WebDriver;
import pages.PaginaPrincipal;

public class AcompanharObjeto {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal;

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
}
