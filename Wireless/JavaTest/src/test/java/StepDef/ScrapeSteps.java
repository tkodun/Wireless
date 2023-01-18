package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ScrapeSteps extends HomePage{

	
	@Given("I navigate to url")
	public void i_navigate_to_url() {
		launchUrl();
	}
	
	@Given("I assert the logo is displayed")
	public void i_assert_the_logo_is_displayed() {
		assertLogo();
	}

	@When("I grab the title of site")
	public void i_grab_the_title_of_site() {
		getTitle();
	}

	@Then("I counted the number of product displayed")
	public void i_counted_the_number_of_product_displayed() {
		iCountProduct();
	}
	
	@Then("I grab all the prices displayed")
	public void i_grab_all_the_prices_displayed() {
		getAllPrice();
	}

	@And("I order by annual price")
	public void i_order_by_annual_price() {
		orderByPriceDesending();
	}
	
	@Then("I write parkage details in a JSON format.")
	public void i_write_parkage_details_in_a_json_format() {
		writeJsonValue();
	}




}
