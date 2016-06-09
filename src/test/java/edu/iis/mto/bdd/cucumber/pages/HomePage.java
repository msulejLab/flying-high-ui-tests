package edu.iis.mto.bdd.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@DefaultUrl("http://localhost:8080/#/home")
public class HomePage extends PageObject {

    @FindBy(id = "welcome-message")
    WebElement welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
