Feature: Add Polo Top to Cart from Brand Category

  Scenario: Add Polo Top and view cart
    When user clicks on Polo brand
    And user adds top to cart
    Then top added popup should be visible
    And user clicks on View Cart