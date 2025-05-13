@Selenium_Test
Feature: Open Browser

  @tag2
  Scenario Outline: Open Browser
    Given I launch the browser
    And I navigate to "<url>"
    Then I should see the page title contains "<title>"

    @test1
    Examples: 
      | url        | title|
      | google.com |Google|
