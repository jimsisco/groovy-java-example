package org.example.stepdefs;


/**
 * BDD Workflow
 */

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Selenium driver
 */

public class StepDefinitions {
   WebDriver driver;
   @Before
    public void initializeTest() {
        // Code to setup initial configurations
        System.setProperty("webdriver.chrome.driver", "/Users/jamessiscaretti/repo/webdrivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Given("^I navigate to Kindercare Home page on URL \"([^\"]*)\"$")
    public void i_ve_landed_on_the_home_page(String arg1) {
        driver.get(arg1);
    }

    @When("^Title is \"([^\"]*)\"$")
    public void title_is(String arg1) {
        String actual1 = driver.getTitle();
        assertEquals(actual1, arg1);
        WebElement button =  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button"));
        button.click();

    }

    @Then("^I click  Find My Center$")
    public void i_click_find_my_center() {
        WebElement button =  driver.findElement(By.xpath("//*[@id=\"homePage\"]/div/div/div[2]/a"));
        button.click();
    }

    @Then("^It should have taken me to Center Search Results | KinderCare$")
    public void it_should_take_me_to_cs() {
        String actual2 = driver.getTitle();
        String test = "Center Search Results | KinderCare";
        assertEquals(actual2, test);
    }

    @Then("^I enter my zip code \"([^\"]*)\"$")
    public void i_enter_my_zip_code(String arg1) {
        driver.findElement(By.xpath("//*[@id=\"center-search-location\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"center-search-location\"]")).sendKeys(arg1);
    }

    @Then("^I click Search Again$")
    public void and_click_Search_Again() {
        WebElement button = driver.findElement(By.xpath("/html/body/main/div[2]/aside/div[2]/form/fieldset[4]/button"));
        button.click();
    }

    @Then("^I can see the center and click Tuition and Openings$")
    public void i_can_see_the_center_and_click_Tuition_and_Openings() {
        WebElement button = driver.findElement(By.xpath("//li[@id='300902']/div/div[2]/a"));
        button.click();
    }

    @Then("^I can see \"([^\"]*)\"$")
    public void i_can_see(String arg1) {
        String actual = driver.getTitle();
        //String test = "Center Search Results | KinderCare";
        assertEquals(actual, arg1);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}