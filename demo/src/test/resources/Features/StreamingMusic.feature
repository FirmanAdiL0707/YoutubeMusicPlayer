Feature: Streaming Music

    Scenario: MY-7  Successfully playing a music
        Given User navigated to music youtube
        And User click search button
        When User input "Keane - Somewhere Only We Know" on input search
        Then Validate that "Somewhere Only We Know" appears on Top Result
        And User click list music on top result
        Then Validate that "Somewhere Only We Know" playing
@run
    Scenario: MY-8  Successfully pause during streaming
        Given User navigated to music youtube
        And User click search button
        When User input "Keane - Somewhere Only We Know" on input search
        Then Validate that "Somewhere Only We Know" appears on Top Result
        And User click list music on top result
        Then Validate that "Somewhere Only We Know" playing
        And User click pause at "25" second after play
        Then Validate button change become "Play"