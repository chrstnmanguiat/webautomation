package webautomation.steps;

import com.microsoft.playwright.*;

public class PlaywrightHelper {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    // Open the browser
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    // Go to a specific website
    public void navigateTo(String url) {
        page.navigate(url);
    }

    // Get the page title
    public String getPageTitle() {
        return page.title();
    }

    // Click an element
    public void clickElement(String selector) {
        page.click(selector);
    }

    // Type text into a field
    public void fillField(String selector, String value) {
        page.fill(selector, value);
    }

    // Check if an element is visible
    public boolean isElementVisible(String selector) {
        return page.locator(selector).isVisible();
    }

    // Get text of an element
    public String getElementText(String selector) {
        return page.locator(selector).innerText();
    }

    // Close the browser
    public void closeBrowser() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}