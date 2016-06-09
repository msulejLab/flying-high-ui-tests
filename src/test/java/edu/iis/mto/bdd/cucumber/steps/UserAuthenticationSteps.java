package edu.iis.mto.bdd.cucumber.steps;

import edu.iis.mto.bdd.cucumber.workflowsteps.AuthenticationWorkFlowSteps;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.iis.mto.bdd.model.FrequentFlyerMember;

public class UserAuthenticationSteps {
	private WebDriver driver;

    @Steps
    private AuthenticationWorkFlowSteps authenticationWorkFlowSteps;

	@Before
	public void init(){
		driver = new FirefoxDriver();
	}
	
    @Given("^(.*) is a registered Frequent Flyer$")
    public void givenARegisteredFrequentFlyer(FrequentFlyerMember member) {}

    @When("^(.*) authenticates with a valid email address and password$")
    public void whenJaneAuthenticatesWithAValidEmailAddressAndPassword(FrequentFlyerMember member) {
        authenticationWorkFlowSteps.enterEmailAndPasswordFor(member);
    }

    @Then("^(.*) should be given access to (?:her|his) account$")
    public void thenTheUserShouldBeGivenAccessToAccount(FrequentFlyerMember member) {
        authenticationWorkFlowSteps.verifyWelcomeMessageFor(member);
    }

    @Given("^(.*) has logged on$")
    public void aUserHasLoggedOnAs(FrequentFlyerMember member) {
    	driver.get("http://localhost:8080/#/welcome");
    	driver.findElement(By.name("email")).sendKeys(member.getEmail());
		driver.findElement(By.name("password")).sendKeys(member.getPassword());
		driver.findElement(By.name("signin")).click();
    }

    @When("^(?:.*) views the home page$")
    public void whenAUserViewsTheHomePage() {}
    
    @After
    public void close(){
    	driver.close();
    }

}
