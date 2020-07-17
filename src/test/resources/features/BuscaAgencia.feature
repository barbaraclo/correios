#language:pt
  @busca_agencia
  Funcionalidade: Busca Agência
    Como um usuário dos correios
    Quero realizar uma busca de agências por localidade
    Para que possa encontrar as informações das agências

  Cenario: Buscar uma agência sem selecionar o Estado
    Dado que o usuário está na página principal
    E deseja realizar uma busca de agência
    Quando o usuário está na página de agências
    E seleciona buscar agência por localidade
    E deixa o campo Estado vazio
    E seleciona o campo Município
    Entao o campo Município retorna uma lista vazia
    E uma mensagem "* Campo obrigatório" é mostrada na tela
