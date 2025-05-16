Feature: Lunch youtube app

    Scenario: Lunch youtube app
        Given I lunch youtube on website
        Then i search for "selenium"
        And I click on the first video
        Then pause the video
        Then chnage the video quality to 1080p
        Then can turn subtitle on
