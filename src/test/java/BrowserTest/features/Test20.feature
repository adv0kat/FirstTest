Feature: LiteCart

  Scenario: Add product to cart and remove it
    Given Open main page
    When Add "3" product to cart
    And Checkout cart
    And Remove product from cart