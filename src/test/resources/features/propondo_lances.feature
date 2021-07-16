Feature: Propondo lances

Scenario: Propondo um unico lance valido
  Given dado um lance valido
  When Quando propoe o lance
  Then Entao o lance eh aceito
