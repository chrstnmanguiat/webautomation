package webautomation.stepdefinitions;

import webautomation.steps.PlaywrightHelper;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlaywrightActions {
    PlaywrightHelper helper = new PlaywrightHelper();

    @Given("I launch the browser with Playwright")
    public void i_launch_the_browser() {
        System.out.println("Launch Browser (Playwright)!");
        helper.launchBrowser();
    }

    @When("I navigate to {string} using Playwright")
    public void i_navigate_to(String url) {
        System.out.println("Navigate to " + url + " (Playwright)");
        helper.navigateTo(url);
    }

    @Then("I should see the page title contains {string} using Playwright")
    public void i_should_see_page_title_contains(String expectedTitle) {
        String actualTitle = helper.getPageTitle();
        assertTrue(actualTitle.contains(expectedTitle), "Title should contain: " + expectedTitle);
        System.out.println("Navigation Correct (Playwright): " + expectedTitle);
        helper.closeBrowser();
    }
}
