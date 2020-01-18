Feature: End2End

@smoke
@e2e

Scenario: Successful login
Given I start the application
When I click email field
And I enter valid email <email>
