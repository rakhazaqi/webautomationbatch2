Feature: Form for Checkout Scenario

Scenario Outline: Positive Test Checkout Form
    Given User was landing on the website
    Given Buyer logged on the website username <username> password <pw>
    When Buyer add product <product_name> to cart
    And Buyer checkout product <product_name>
    And Buyer place order firstname <first_name>, lastname <last_name>, and postal <postal>
    Then Buyer will see message is displayed on confirmation page <confirm_text>

    Examples:
    |username         |pw           |product_name           |first_name |last_name  |postal |confirm_text               |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |123456 |Thank you for your order!  |

Scenario Outline: Negative Test Checkout Form
    Given User was landing on the website
    Given Buyer logged on the website username <username> password <pw>
    When Buyer add product <product_name> to cart
    And Buyer checkout product <product_name>
    And Buyer places order firstname "<first_name>", lastname "<last_name>", and postal code "<postal>"
    Then Buyer will see error message is displayed <errormsg>

    Examples:
    |username         |pw           |product_name           |first_name |last_name  |postal |errormsg                       |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |           |123456 |Error: Last Name is required   |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |           |Samardzic  |123456 |Error: First Name is required  |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |       |Error: Postal Code is required |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |           |           |       |Error: First Name is required  |
