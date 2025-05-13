package webautomation.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; 
import org.openqa.selenium.WebElement;

public class SeleniumHelper {
    private WebDriver driver;

    // Launch browser 
    public void launchBrowser() {
        // Set path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Win 10\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ChromeOptions to customize Chrome's launch behavior
        ChromeOptions options = new ChromeOptions();

        // Start Chrome maximized by default
        options.addArguments("--start-maximized");

        // Launch Chrome with options
        driver = new ChromeDriver(options);
        wait(5);
    }

    // Navigate to a given URL
    public void navigateTo(String url) {
        try {
	    	 if (!url.startsWith("http://") && !url.startsWith("https://")) {
	              url = "https://" + url;
	         }
        	 driver.get(url);
        	 wait(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Click an element by its selector
    public void clickElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    // Fill a form field 
    public void fillField(String xpath, String value) {
        WebElement field = driver.findElement(By.xpath(xpath));
        field.sendKeys(value);
    }

    // Get text from an element
    public String getElementText(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();
    }

    // Check if an element is visible
    public boolean isElementVisible(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

    // Close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
 // Method to wait for a specific amount of time
    public void wait(int seconds) {
        try {
            // Convert seconds to milliseconds and wait
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}