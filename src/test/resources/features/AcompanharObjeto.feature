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

  @cenario04
  Cenario: Realizar rastreamento de objetos com valor vazio
    Dado que o usuário está na página de rastreamento
    Quando o usuário clica em buscar
    Entao a mensagem de alerta "Por favor, digite de um a 50 códigos de objetos, ou um CPF/CNPJ válido" é mostrada ao usuário

  @cenario05
  Cenario: Realizar rastreamento de 51 objetos por código
    Dado que o usuário está na página de rastreamento
    Quando o usuário procura os objetos: "JN371586940BR;JN371586941BR;JN371586942BR;JN371586943BR;JN371586944BR;JN371586945BR;JN371586946BR;JN371586947BR;JN371586948BR;JN371586949BR;JN371586950BR;JN371586951BR;JN371586952BR;JN371586953BR;JN371586954BR;JN371586955BR;JN371586956BR;JN371586957BR;JN371586958BR;JN371586959BR;JN371586960BR;JN371586961BR;JN371586962BR;JN371586963BR;JN371586964BR;JN371586965BR;JN371586966BR;JN371586967BR;JN371586968BR;JN371586969BR;JN371586970BR;JN371586971BR;JN371586972BR;JN371586973BR;JN371586974BR;JN371586975BR;JN371586976BR;JN371586977BR;JN371586978BR;JN371586979BR;JN371586980BR;JN371586981BR;JN371586982BR;JN371586983BR;JN371586984BR;JN371586985BR;JN371586986BR;JN371586987BR;JN371586988BR;JN371586989BR;JN371586990BR;JN371586991BR;"
    E o usuário clica em buscar
    Entao a mensagem de informação "Por favor, digite de um a 50 códigos de objetos, ou um CPF/CNPJ válido" é mostrada ao usuário