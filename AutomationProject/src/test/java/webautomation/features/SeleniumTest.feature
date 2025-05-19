@Selenium_Test
Feature: Open Browser

  @tag2
  Scenario Outline: Open Browser
    Given I launch the browser
    And I navigate to "<url>"
    And I login using my credentials "username", "password"
    And I view and add item to the cart
    Then I proceed to check out

    @test1
    Examples: 
      | url                             | username         | password     | typeOfCard |
      | https://automationexercise.com/ | piping@gmail.com | secret_sauce | visa       |
