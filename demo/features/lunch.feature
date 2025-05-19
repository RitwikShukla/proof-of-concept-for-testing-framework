Feature: Launch youtube app

    Scenario: Launch youtube app
        Given I lunch youtube on website
        And i search for "selenium"
        And I click on the first video
        And pause the video
        And change the video quality to 1080p
        Then can turn subtitle on
