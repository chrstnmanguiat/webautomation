@Playwright_Test
Feature: Open Browser with Playwright

  @tag2
  Scenario Outline: Open Browser using Playwright
    Given I launch the browser with Playwright
    And I navigate to "<url>" using Playwright
    Then I should see the page title contains "<title>" using Playwright

    @test1
    Examples: 
      | url         | title  |
      | https://www.google.com | Google |
