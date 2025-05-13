package webautomation.stepdefinitions;

import webautomation.steps.SeleniumHelper;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumActions {
    SeleniumHelper helper = new SeleniumHelper();

    @Given("I launch the browser")
    public void i_launch_the_browser() {
    	System.out.println("Launch Browser!");
        helper.launchBrowser();
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String url) {
    	System.out.println("Navigate to " + url);
        helper.navigateTo(url);
    }

    @Then("I should see the page title contains {string}")
    public void i_should_see_page_title_contains(String expectedTitle) {
        String actualTitle = helper.getPageTitle();
        assertTrue(actualTitle.contains(expectedTitle), "Title should contain: " + expectedTitle);
        System.out.println("Navigation Correct " + expectedTitle);
        helper.closeBrowser();
    }
}