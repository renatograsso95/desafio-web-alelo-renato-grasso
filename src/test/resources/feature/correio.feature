# encoding: utf-8
# language: pt

  @correios

Funcionalidade: Pesquisa de Endereço


  Contexto:
  Dado que eu estou no site do Correios

  @PesquisaCEP
  Esquema do Cenário: Deve pesquisar um CEP e dar output das informações retornadas.
  Quando realizar a pesquisa por "<cep>"
  Entao ira retorna o output das informacoes solicitadas

  Exemplos:
  |  cep    |
  | 05835003|


  @PesquisaLogradouro
  Esquema do Cenário: Deve pesquisar um logradouro que retorne mais de um resultado e dar output de todos os dados da tabela retornada.
  Quando realizar a pesquisa por "<logradouro>"
  Entao ira retorna o output das informacoes solicitadas

  Exemplos:
  |      logradouro     |
  | Rua Soriano de Souza|
