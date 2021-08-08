Feature: Search Feature

   Scenario: MY-1  Input Text Box should appears after Click Search Button
    Given User navigated to music youtube
    And User click search button
    When User input "Keane - Somewhere Only We Know" on input search
    Then Validate that "Somewhere Only We Know" appears on Top Result