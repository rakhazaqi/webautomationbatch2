# Feature: Purchase order from e-commerce

# Background: User was landing on the website
#     Given User was landing on the website

# Scenario Outline: Create order positive case
#     Given Buyer logged on the website
#     Given User logged on the website username <username> password <pw>
#     When User add product <product_name> to cart
#     And User remove product<product_name> from cart
#     Then User will see cart is empty

#     Examples:
#     |username         |pw           |product_name           |
#     |standard_user    |secret_sauce |Sauce Labs Bike Light  |