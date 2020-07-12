#language:pt

@acompanhar_objeto
Funcionalidade: Acompanhar objeto
  Como um usuário dos correios
  Quero verificar o acompanhamento de um ou mais objetos por código ou pelo CPF/CNPJ
  Para que possa encontrar as informações de rastreamento do objeto

  @cenario01
  Cenario: Realizar um rastreamento de objeto utilizando um CPF/CNPJ válido
    Dado que o usuário está na página principal do site
    E deseja verificar o acompanhamento de um objeto
    Quando o usuário procura o CPF "06857466408"
    E não está logado
    Entao o usuário é redirecionado para a página de resultado de rastreamento
    E visualiza a mensagem "Faça seu cadastro o IdCorreios"
    E o botão cadastre-se é visualizado

  @cenario02
  Cenario: Realizar um rastreamento de objeto utilizando um CPF/CNPJ inválido
    Dado que o usuário está na página principal do site
    E deseja verificar o acompanhamento de um objeto
    Quando o usuário procura o CPF "893485"
    Entao o usuário é redirecionado para a página de resultado de rastreamento
    E visualiza a mensagem "O(s) código(s) ou CPF/CNPJ estão inválidos"

  @cenario03
  Cenario: Realizar um rastreamento de objeto utilizando um código de rastreamento válido
    Dado que o usuário está na página principal do site
    E deseja verificar o acompanhamento de um objeto
    Quando o usuário procura código "JN371586967BR"
    Entao o usuário é redirecionado para a página de resultado de rastreamento
    E o sistema exibe as informações de rastreamento do objeto