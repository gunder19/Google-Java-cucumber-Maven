Feature: Selenium Cucumber Java Example

  Scenario Outline: Google search
    Given "<browser>" browser is used
    When User is on Google search page
    When User searches "<word>" on Google page
    Then verify search results appeared on the page
    When click first real (non-Ad) result
    Then page was opened
    And page contains "<word>"
      Examples:
    | browser   | word                            |
    | CHROME    | configurable in test properties |

#  Scenario Outline: Google search
#    Given "<browser>" browser is used
#    When User is on Google search page
#    When User searches "<word>" on Google page
#    Then verify search results appeared on the page
#    When click first real (non-Ad) result
#    Then page was opened
#    And page contains "<word>"
#    Examples:
#      | browser   | word                            |
#      | CHROME    | configurable in test properties |
#      | FIREFOX   | configurable in test properties |
#      | EDGE      | configurable in test properties |
#      | OPERA     | configurable in test properties |
#      | IE        | configurable in test properties |
