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
    
    @When("I login using my credentials {string}, {string}")
    public void i_login_using_my_credentials(String username, String password) {
    	System.out.println("Login");
    	helper.clickElement("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a/i");
    	// Wait for the page to load
    	helper.wait(5);
    	
    	// Input Username
    	helper.fillField("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]", "piping@gmail.com");
    	
    	// Input Password and Press Enter
    	helper.fillFieldWithEnter("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]", "secret_sauce");
    	
    	// Wait for the page to load
    	helper.wait(5);
    	
    }
    
    @When("I view and add item to the cart")
    public void i_view_and_add_item_to_the_cart() {
    	System.out.println("View and Add Item to The card");
    	
    	// Click view Item
    	helper.clickElement("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    	// Wait for the page to load
    	helper.wait(3);
    	
    	// Add to Card
    	helper.clickElement("//button[contains(@type, 'button')]");
    	helper.wait(2);
    	
    	// Verify add to cart item
    	String addToCardMessage = helper.getElementText("//*[@id=\"cartModal\"]/div/div/div[2]/p[1]");
    	assertTrue(addToCardMessage.contains("Your product has been added to cart."), "Item Added to Cart!");
    	
    	// Wait for the page to load
    	helper.wait(2);
    	
    	// Continue Shopping
    	helper.clickElement("//button[contains(@class, 'btn btn-success close-modal btn-block')]");
    	helper.wait(2);
    	
    }
    
    @Then("I proceed to check out")
    public void i_proceed_to_check_out() {
    	System.out.println("Proceed to checkout");
    	
    	// Navigate to Cart
    	helper.clickElement("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    	// Wait for the page to load
    	helper.wait(5);
    	
    	// Proceed to checkout
    	helper.clickElement("//*[@id=\"do_action\"]/div[1]/div/div/a");
    	helper.wait(5);
    	
    	// Place Order
    	helper.clickElement("//a[contains(@class, 'btn btn-default check_out')]");
    	
    	// Wait for the page to load
    	helper.wait(5);
    	
    	// Type of Card
    	String cardNumber = "4242 4242 4242 4242";
//    	if(typeOfCard.equals("Visa")) {
//    		cardNumber = "4242 4242 4242 4242";
//    	}
//    	else if(typeOfCard.equals("Master")) {
//    		cardNumber = "5555 5555 5555 4444";
//    	}
//    	else {
//    		System.out.println("Invalid Type of Card");
//    		return;
//    	}
    	
    	// Input Name on Card
    	helper.fillField("//input[@name='name_on_card']", "Sample Name");
    	helper.wait(1);
    	
    	// Input Card Number
    	helper.fillField("//input[@name='card_number']", cardNumber);
    	helper.wait(1);
    	
    	// Input CVC
    	helper.fillField("//input[@name='cvc']", "123");
    	helper.wait(1);
    	
    	// Input expiryDateMonth
    	helper.fillField("//input[@name='expiry_month']", "12");
    	helper.wait(1);
    	
    	// Input expiryDateYear
    	helper.fillField("//input[@name='expiry_year']", "1934");
    	helper.wait(1);
    	
    	// Pay and confirm order
    	helper.clickElement("//button[@id='submit']");
    	
    	// Wait for page to load
    	helper.wait(7);
    	
    	// Verify Payment Success
    	String paymentSuccessMessage = helper.getElementText("//*[@id=\"form\"]/div/div/div/p");
    	assertTrue(paymentSuccessMessage.contains("Congratulations! Your order has been confirmed!"), "Payment Success");
    	helper.wait(1);
    	
    	// Navigate to Cart
    	helper.clickElement("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    	
    	// Verify Cart is Empty
    	String cartIsEmpty = helper.getElementText("//*[@class=\"text-center\"]");
    	assertTrue(cartIsEmpty.contains(" is empty!"), "Cart is Empty!");
    	helper.wait(1);
    	helper.closeBrowser();
    }

    @Then("I should see the page title contains {string}")
    public void i_should_see_page_title_contains(String expectedTitle) {
        String actualTitle = helper.getPageTitle();
        assertTrue(actualTitle.contains(expectedTitle), "Title should contain: " + expectedTitle);
        System.out.println("Navigation Correct " + expectedTitle);
        helper.closeBrowser();
    }
}