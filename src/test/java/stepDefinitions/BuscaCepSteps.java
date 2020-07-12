package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BuscaCepSteps {

    @Dado("que o usuário está na página principal")
    public void paginaPrincipal() {

    }

    @Dado("deseja realizar uma busca de endereço")
    public void buscaCampoEndereco() {

    }

    @Quando("o usuário procura o cep {string}")
    public void buscaCep(String cep) {

    }

    @Entao("o usuário é redirecionado para a página de resultado de busca")
    public void resultadoDeBusca() {

    }

    @Entao("visualiza a mensagem {string}")
    public void visualizaMensagem(String mensagem) {

    }

    @Entao("o sistema exibe os dados do endereço corretamente")
    public void validaEndereco() {

    }

    @Entao("o sistema exibe uma tabela com todos os endereços que contém os digitos informados")
    public void validaTabela() {

    }

    @Quando("o usuário procura o logradouro {string}")
    public void buscaLogradouro(String logradouro) {

    }

}
