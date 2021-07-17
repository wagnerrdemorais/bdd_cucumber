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

Scenario Outline: Propondo um lance invalido
  Given um lance de <valor> reais e do usuario '<nomeUsuario>'
  When Quando propoe ao leilao
  Then o lance nao eh aceito

Examples:
  | valor | nomeUsuario |
  | 0.0   |  beltrano  |
  | -1.0  |  tiozinho  |

Scenario: Propondo uma sequencia de lances
  Given dois lances
    | valor | nomeUsuario |
    | 10.0  | beltrano    |
    | 15.0  | beltrano    |
  When propoe varios lances ao leilao
  Then o segundo lance nao eh aceito