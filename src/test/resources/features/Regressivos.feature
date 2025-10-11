Feature: Regressivos
  Scenario: CT001 - Criar reserva com sucesso
    Given que desejo criar uma reserva
    When realizar a requisição
    Then deve ser criado com sucesso

  Scenario: CT002 - Consultar reserva com sucesso
    Given que ao informar o id da reserva
    When realizar a requisição de consulta
    Then deve ser consultado com sucesso

  Scenario: CT003 - Alterar reserva com sucesso
    Given que ao informar informo os dados que desejo alterar
    When realizar a requisição de alteração
    Then deve ser alterado com sucesso

  Scenario: CT004 - Deletar reserva com sucesso
    Given que ao informar informo os dados que desejo deletar
    When realizar a requisição de delete
    Then deve ser deletado com sucesso