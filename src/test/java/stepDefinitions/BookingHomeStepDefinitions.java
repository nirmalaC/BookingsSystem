package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import helpers.UiHelper;
import helpers.Utils;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BookingHomePage;

import java.util.Random;

import static helpers.UiHelper.*;

public class BookingHomeStepDefinitions {

    private BookingHomePage page = PageFactory.initElements(BookingHomePage.driver, BookingHomePage.class);
    private final Character firstNameSuffix = Utils.randomChar();

    @Given("^I enter vaild details : (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void iEnterVaildDetailsFirstnameSurenamePriceDeposit(String firstName, String surName, String bookingPrice, String deposit, String checinDate, String checkoutDate ) {
        page.enterDetails(firstName + firstNameSuffix,surName, bookingPrice, deposit, checinDate, checkoutDate);
    }

    @When("^I click on the save button$")
    public void iClickOnTheSaveButton() {
        page.clickSaveButton();
    }

    @Then("^I should be able to save the booking : (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void iShouldBeAbleToMake(String firstName, String surName, String bookingPrice, String deposit, String checinDate, String checkoutDate) throws Throwable {
        page.checkDetailsIsDisplayed(firstName + firstNameSuffix, surName, bookingPrice, deposit,checinDate,checkoutDate );
    }

    @Given("^vaild booking exists : (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void vaildBookingExistsFirstnameSurename(String firstName, String surName, String bookingPrice, String deposit, String checinDate, String checkoutDate) {
        page.checkDetailsIsDisplayed(firstName + firstNameSuffix, surName, bookingPrice, deposit,checinDate,checkoutDate );
    }

    @When("^I click on the delete button : (.*)$")
    public void iClickOnTheDeleteButton(String firstName){
        page.clickDeleteButton(firstName+firstNameSuffix);
    }

    @Then("^the saved bookings should be deleted : (.*), (.*)$")
    public void theSavedBookingsShouldBeDeletedFirstnameSurename(String firstName, String surName) {
        page.checkDetailsAreNotDisplayed(firstName + firstNameSuffix, surName);
    }
}