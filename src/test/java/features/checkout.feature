Feature: Proceed to Checkout from Cart

  Scenario: Proceed to Checkout and Login/Register
    When user clicks on Proceed to Checkout button
    Then user should see the login & register popup
    And user clicks on Login or Register link from popup
    Then new window should open for login or registration
