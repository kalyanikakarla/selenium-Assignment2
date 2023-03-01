Feature:

  Scenario: : verify the message
    Given User on Homepage
    When User click on contact
    Then User enters Name and Email and Message
    And Click on submit button
    And verify the message
