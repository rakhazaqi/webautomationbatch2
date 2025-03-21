Feature: Purchase order from e-commerce

Background: User was landing on the website
    Given User was landing on the website

# Scenario: Create order positive case
#     Given Buyer logged on the website
#     When Buyer add product on the website
#     And Buyer checkout product
#     And Buyer place order
#     Then Buyer will see message is displayed on confirmation page

Scenario Outline: Create order positive case
    Given Buyer logged on the website
    Given Buyer logged on the website username <username> password <pw>
    When Buyer add product <product_name> to cart
    And Buyer checkout product <product_name>
    And Buyer place order firstname <first_name>, lastname <last_name>, and postal <postal>
    Then Buyer will see message is displayed on confirmation page <confirm_text>

    Examples:
    |username         |pw           |product_name           |first_name |last_name  |postal |confirm_text               |
    |standard_user    |secret_sauce |Sauce Labs Bike Light  |Lazar      |Samardzic  |123456 |Thank you for your order!  |