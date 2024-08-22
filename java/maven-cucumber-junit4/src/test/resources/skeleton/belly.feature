Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl

  Scenario Outline: a certain amount of cukes
    Given I have <a> cukes in my belly
    When I wait 1 hour
    Then my belly should growl

    Examples: Single digits
      | a |
      | 1 |
      | 2 |

    Examples: Double digits
      | a  |
      | 10 |
      | 20 |