package edu.iis.mto.bdd.cucumber.workflowsteps;

import edu.iis.mto.bdd.cucumber.pages.HomePage;
import edu.iis.mto.bdd.cucumber.pages.LoginPage;
import edu.iis.mto.bdd.model.FrequentFlyerMember;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationWorkFlowSteps {
    private LoginPage loginPage;
    private HomePage homePage;

    public AuthenticationWorkFlowSteps() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Step
    public void enterEmailAndPasswordFor(FrequentFlyerMember member) {
        loginPage.open();

        loginPage.signIn(member.getEmail(), member.getPassword());
    }

    @Step
    public void verifyWelcomeMessageFor(FrequentFlyerMember member) {
        homePage.open();

        String welcomeMessage = homePage.getWelcomeMessage();
        assertThat(welcomeMessage, equalTo("Witaj " + member.getFirstName()));
    }
}
