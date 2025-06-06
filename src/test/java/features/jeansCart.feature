Feature: Add Jeans to Cart from Men Category

  Scenario: Navigate Men > Jeans, Add to cart and verify popup
    When user navigates to Men category and selects Jeans
    And user adds jeans to cart
    Then jeans added popup should be visible
    And user clicks on continue shopping