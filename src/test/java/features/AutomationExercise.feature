Feature: Automation Exercise Site Tests

  Scenario: Open homepage and check logo
    Given user launches the browser
    When user navigates to homepage
    Then logo should be visible

  Scenario: Navigate Men > Jeans, Add to cart and verify popup
    Given user launches the browser
    When user navigates to homepage
    And user navigates to Men category and selects Jeans
    And user adds jeans to cart
    Then added popup should be visible
    And user clicks on continue shopping
    And user clicks on Polo brand
    And user adds top to cart
    Then added popup should be visible
    And user clicks on View Cart