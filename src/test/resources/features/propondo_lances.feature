Feature: Propondo lances ao leilao

Scenario: Propondo um unico lance valido
  Given dado um lance valido
  When Quando propoe ao leilao
  Then Entao o lance eh aceito

Scenario: Propondo varios lances validos
  Given um lance de 10.0 reais do usuario "fulano"
  And um lance de 15.0 reais do usuario "beltrano"
  When propoe varios lances ao leilao
  Then os lances sao aceitos