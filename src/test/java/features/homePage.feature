Feature: Homepage Verification

  Scenario: Open homepage and check logo
    Given user launches the browser
    When user navigates to homepage
    Then logo should be visible