#enconding: UTF-8
#language: pt

@BlogDoAgi
Funcionalidade: Validar lupa de busca


  @ValidarPesquisarInformacao
  Esquema do Cenario: Realizar a pesquisa de informação no blog
    Dado Que estou na pagina inical do blog do agi
    Quando clicar na lupa
    E Na barra de pesquisa informar: <InformacaoBuscada>
    E clicar no botão pesquisar
    Então na tela de resultado da pequisa devera retornar a mensagem: <ResultadoEsperado>
    E gravar evidencia
    E fechar navegador

    Exemplos: Informação a serem buscadas
      | InformacaoBuscada                              | ResultadoEsperado                               |
      | "Comece sua carreira em tecnologia com o Agi!" | "Comece sua carreira em tecnologia com o Agi!"  |
      | "Adsasasdasd"                                  | "Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras." |

  @ValidarFecharBarraPesquisa
  Cenario: Validar fechar barra de pesquisa
    Dado Que estou na pagina inicial do blog agi
    Quando clicar  na lupa a barra de pesquisa sera aberta
    E clicar novamente na lupa
    Entao a barra de pesquisa devera ser fechada
    E gravar a evidencia
    E fechar a navegador

