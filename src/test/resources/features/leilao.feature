@leilao
Feature: Cadastrando um leilao

  Scenario: Um usuario logado pode cadastrar um leilao
    Given um usuario logado
    When acessa a pagina de novo leilao
    And preenche o formulario com dados validos
    Then volta para a pagina de leiloes
    And o novo leilao aparece na tabela
