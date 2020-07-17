package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import manager.GerenciadorDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BuscaEnderecoPagina;
import pages.PaginaPrincipal;
import pages.ResultadoEnderecoPagina;

public class BuscaEnderecoSteps {

    private WebDriver driver = GerenciadorDriver.getDriver();
    private PaginaPrincipal paginaPrincipal= new PaginaPrincipal(driver);
    private ResultadoEnderecoPagina resultadoEndPagina = new ResultadoEnderecoPagina(driver);
    private BuscaEnderecoPagina buscaEndPagina = new BuscaEnderecoPagina(driver);

    @Dado("que o usuário está na página principal")
    public void paginaPrincipal() {
        paginaPrincipal.acessarPagina();

    }

    @Dado("deseja realizar uma busca de endereço")
    public void buscaCampoEndereco() {
        paginaPrincipal.getEndereco();

    }

    @Quando("o usuário procura o cep {string}")
    public void buscaCep(String cep) {

        buscaEndPagina.enviaEndereco(cep);
        buscaEndPagina.clicaBusca();
    }

    @Entao("o usuário é redirecionado para a página de resultado de busca")
    public void resultadoDeBusca() {
        paginaPrincipal.mudaAba(driver);
        String retorno = resultadoEndPagina.getUrlResultado();
        Assert.assertEquals(retorno,driver.getCurrentUrl());

    }

    @Entao("visualiza a mensagem {string}")
    public void visualizaMensagem(String mensagem) {
        Assert.assertEquals(resultadoEndPagina.validaMensagem(),mensagem);
    }

    @Entao("o sistema exibe os dados do endereço do cep {string} corretamente")
    public void validaCep(String cep) {
        Assert.assertEquals(cep, resultadoEndPagina.validaCep());

    }

    @Entao("o sistema exibe uma tabela com todos os endereços que o CEP contém {string}")
    public void validaTabela(String cep) {
        System.out.println(resultadoEndPagina.validaTabelaCep(cep));
        Assert.assertTrue(resultadoEndPagina.validaTabelaCep(cep));

    }

    @Quando("o usuário procura o logradouro {string}")
    public void buscaLogradouro(String logradouro) {
        buscaEndPagina.enviaEndereco(logradouro);
        buscaEndPagina.clicaBusca();

    }

    @Entao("o sistema exibe os dados do endereço do logradouro {string}")
    public void validaLogradouro(String logradouro) {
        Assert.assertTrue(resultadoEndPagina.validaLogradouro(logradouro));
    }

}
