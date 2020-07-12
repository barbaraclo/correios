package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.openqa.selenium.WebDriver;
import pages.BuscaEnderecoPagina;
import pages.PaginaPrincipal;

public class BuscaEnderecoSteps {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal;

    @Dado("que o usuário está na página principal")
    public void paginaPrincipal() {
        paginaPrincipal = new PaginaPrincipal(driver);
        paginaPrincipal.acessarPagina();
        //precisa modificar por conta do hoocks

    }

    @Dado("deseja realizar uma busca de endereço")
    public void buscaCampoEndereco() {

    }

    @Quando("o usuário procura o cep {string}")
    public void buscaCep(String cep) {
        BuscaEnderecoPagina enderecoPagina = new BuscaEnderecoPagina(driver);
        enderecoPagina.enviaEndereco(cep);
        enderecoPagina.clicaBusca();
    }

    @Entao("o usuário é redirecionado para a página de resultado de busca")
    public void resultadoDeBusca() {

    }

    @Entao("visualiza a mensagem {string}")
    public void visualizaMensagem(String mensagem) {

    }

    @Entao("o sistema exibe os dados do endereço do cep {string} corretamente")
    public void validaEndereco(String cep) {

    }

    @Entao("o sistema exibe uma tabela com todos os endereços que o CEP contém {string}")
    public void validaTabela(String cep) {

    }

    @Quando("o usuário procura o logradouro {string}")
    public void buscaLogradouro(String logradouro) {

    }

    @Entao("o sistema exibe os dados do endereço do logradouro {string}")
    public void validaLogradouro(String logradouro) {

    }

}
