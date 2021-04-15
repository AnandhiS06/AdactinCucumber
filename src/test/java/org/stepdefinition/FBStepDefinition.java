package org.stepdefinition;

import org.baseclass.BaseClass;
import org.fbforpasspojo.FbForgetPasswordPagePojo;
import org.fbhomepojo.FbHomePagePojo;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBStepDefinition extends BaseClass {
	
	public FbHomePagePojo fbHome;
	public FbForgetPasswordPagePojo fbForPass;

	@Given("User is in Facebook page")
	public void user_is_in_Facebook_page() {
		launchUrl("https://www.faceboo.com/");
		fbHome = new FbHomePagePojo();
		fbForPass = new FbForgetPasswordPagePojo();
	}

	@When("User enter invalid {string} and invalid {string}")
	public void user_enter_invalid_and_invalid(String userName, String password) {
		enterText(fbHome.getTxtUser(), userName);
		enterText(fbHome.getTxtPassword(), password);
	}

	@When("User click login button")
	public void user_click_login_button() throws InterruptedException {
		clickBtn(fbHome.getBtnLogin());
		waitWithThread();
	}

	@Then("User should be in invalid credentials page")
	public void user_should_be_in_invalid_credentials_page() {
		if (pageUrl().contains("privacy")) {
			System.out.println("User is in Invalid Credentials Page");
		} else if (driver.findElement(By.xpath("//span[@class='l9j0dhe7']")).isDisplayed()) {
			System.out.println("User is in Home Page");
		}
	}

	@When("User click login button without entering any details")
	public void user_click_login_button_without_entering_any_details() throws InterruptedException {
		clickBtn(fbHome.getBtnLogin());
		waitWithThread();
	}

}
