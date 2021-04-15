@facebooklogin
Feature: To validate Login Functionality in Facebook Application

  Background: 
    Given User is in Facebook page

  @regression
  Scenario Outline: To validate login using invalid username and password
    When User enter invalid "<username>" and invalid "<password>"
    And User click login button
    Then User should be in invalid credentials page

    Examples: 
      | username | password     |
      | mridvika | Mridvika@123 |

  @sanity @smoke
  Scenario: To validate login using empty username and password
    When User click login button without entering any details
    Then User should be in invalid credentials page
