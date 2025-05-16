package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;


public class lunch {

    HomePage homePage;

    @Given("I lunch youtube on website")
    public void i_lunch_youtube_on_website() {
        homePage = new HomePage(Hooks.reporter);
    }

    @Then("i search for {string}")
    public void i_search_for(String string) {
        homePage.enterSearchText(string);
        
    }

    @Then("I click on the first video")
    public void i_click_on_the_first_video() {

    }

    @Then("pause the video")
    public void pause_the_video() {

    }

    @Then("chnage the video quality to 1080p")
    public void chnage_the_video_quality_to_1080p() {

    }

    @Then("can turn subtitle on")
    public void can_turn_subtitle_on() {

    }
}
