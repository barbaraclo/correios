#language:pt

@busca_cep
  Funcionalidade: Buscar endereço
    Como um usuário dos correios
    Quero realizar uma busca de endereço pelo cep ou logradouro
    Para que possa encontrar as informações de CEP ou logradouro

    Cenario: Realizar uma busca utilizando um CEP válido
      Dado que o usuário está na página principal
      E deseja realizar uma busca de endereço
      Quando o usuário procura o cep "50030-230"
      Entao o usuário é redirecionado para a página de resultado de busca
      E visualiza a mensagem "DADOS ENCONTRADOS COM SUCESSO."
      E o sistema exibe os dados do endereço corretamente

    Cenario: Realizar uma busca utilizando os 6 primeiros digitos do CEP
      Dado que o usuário está na página principal
      E deseja realizar uma busca de endereço
      Quando o usuário procura o cep "508703"
      Entao o usuário é redirecionado para a página de resultado de busca
      E visualiza a mensagem "DADOS ENCONTRADOS COM SUCESSO."
      E o sistema exibe uma tabela com todos os endereços que contém os digitos informados

    Cenario: Realizar uma busca utilizando um CEP inexistente
      Dado que o usuário está na página principal
      E deseja realizar uma busca de endereço
      Quando o usuário procura o cep "12345678911"
      Entao o usuário é redirecionado para a página de resultado de busca
      E visualiza a mensagem "DADOS NAO ENCONTRADOS"

    Cenario: Realizar uma busca utilizando um logradouro existente
      Dado que o usuário está na página principal
      E deseja realizar uma busca de endereço
      Quando o usuário procura o logradouro "Rua Capitão Domingos da Costa"
      Entao o usuário é redirecionado para a página de resultado de busca
      E visualiza a mensagem "DADOS ENCONTRADOS COM SUCESSO."
      E o sistema exibe os dados do endereço corretamente

    Cenario: Realizar uma busca utilizando um logradouro com o número da residência
      Dado que o usuário está na página principal
      E deseja realizar uma busca de endereço
      Quando o usuário procura o logradouro "Cais do Apolo 77"
      Entao o usuário é redirecionado para a página de resultado de busca
      E visualiza a mensagem "DADOS NAO ENCONTRADOS"