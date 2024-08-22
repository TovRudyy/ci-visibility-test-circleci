Feature: Bank Account Parser

  This tests my awesome account parser

  Scenario: read account numbers
    Given I have an account file with contents:
      """
      Account: 123456789
      """
    When I parse the file
    Then the first account number is "123456789"
