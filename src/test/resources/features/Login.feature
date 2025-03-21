Feature: Login Scenario Ecommerce

Scenario Outline: Positive scenario to login ecommerce
    Given User was landing on the website
    When User fills in username <username> and password <pw> on the login form
    Then User was landing on the product list page

    Examples:
    |username         |pw           |
    |standard_user    |secret_sauce |
    

Scenario Outline: Negative scenario to login ecommerce
    Given User was landing on the website
    When User fills in username <username> and password <pw> on the login form
    # And User click submit button
    Then User will see error message is displayed <errormsg>

    Examples:
    |username           |pw           |errormsg                                                                   |
    |nice_user          |secret_sauce |Epic sadface: Username and password do not match any user in this service  |
    |standard_user      |wrong_sauce  |Epic sadface: Username and password do not match any user in this service  |
    |standard_user      |""           |Epic sadface: Password is required                                         |
    |""                 |secret_sauce |Epic sadface: Username is required                                         |
    |""                 |""           |Epic sadface: Username is required                                         |


