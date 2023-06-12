package stepDefinations;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
    @Given("^user is in the registerpage$")
    public void user_is_in_the_registerpage() throws Throwable {
       System.out.println("user is in the register page for Timesjobs portal");
    }

    @When("^user enter following details$")
    public void user_enter_following_details(DataTable table) throws Throwable {
    	List<List<String>> cells = table.cells();
    	String fname = cells.get(0).get(0);
    	String lname = cells.get(0).get(1);
    	String email = cells.get(0).get(2);
    	String phonenumber = cells.get(0).get(3);
    	String location = cells.get(0).get(4);
    	System.out.println("user entered first name as "+fname+"enter last name as "+lname
    			+" email as "+email+" entered phone number as "+phonenumber+" location as "+ location);
      
    }

    @Then("^successfully an account should be created$")
    public void successfully_an_account_should_be_created() throws Throwable {
        System.out.println("successfully an account is created");
    }

    @And("^clicks on submit button$")
    public void clicks_on_submit_button() throws Throwable {
       System.out.println("user clicked on submit button");
    }
}
