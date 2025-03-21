Feature: Form for Checkout Scenario

Scenario Outline: Positive Test Checkout Form
    Given Buyer logged on the website username <username> password <pw>
    When Buyer add product <product_name> to cart
    And Buyer checkout product
    And Buyer place order firstname <first_name>, lastname <last_name>, and postal <postal>
    Then Buyer will see message is displayed on confirmation page

    Examples:
    |username         |pw           |product_name           |first_name |last_name  |postal |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |123456 |

Scenario Outline: Negative Test Checkout Form
    Given Buyer logged on the website username <username> password <pw>
    When Buyer add product <product_name> to cart
    And Buyer checkout product
    And Buyer place order firstname <first_name>, lastname <last_name>, and postal <postal>
    Then Buyer will see error message is displayed <errormsg>

    Examples:
    |username         |pw           |product_name           |first_name |last_name  |postal |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |123456 |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |           |123456 |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |           |Samardzic  |123456 |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |       |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |           |           |       |
