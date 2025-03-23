Feature: Logout Scenario Ecommerce

Scenario Outline: Logout scenario from ecommerce
    Given User was landing on the website
    When User fills in username "<username>" and password "<pw>" on the login form
    And User was landing on the product list page
    And User choice Logout on the menu button
    Then User was landing on the login page

    Examples:
    |username         |pw           |
    |standard_user    |secret_sauce |