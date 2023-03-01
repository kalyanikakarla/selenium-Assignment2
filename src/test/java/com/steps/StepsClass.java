package com.steps;

import Actions.SeleniumActions;
import com.Form.FormData;
import com.Form.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import runner.RunnerClass;

public class StepsClass extends RunnerClass {

    public static WebDriver driver;

    @After
    public static void killSession(){

        driver.quit();
    }
    @Before
    public  void setUp(){
        WebDriverManager.edgedriver().setup();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        chromeOptions.merge(desiredCapabilities);
        driver = new ChromeDriver(chromeOptions);
        driver.get(" https://compendiumdev.co.uk/");
    }
    @Given("User on Homepage")
    public void user_on_homepage() {
        System.out.println("user on home page");

    }
    @When("User click on contact")
    public void user_click_on_contact() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnContact();
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
       Thread.sleep(3000);

    }
    @Then("User enters Name and Email and Message")
    public void user_enters_name_and_email_and_message() throws InterruptedException {
    FormData formData2=new FormData(driver);
    formData2.data();
    Thread.sleep(3000);
    }

    @Then("Click on submit button")
    public void click_on_submit_button() throws InterruptedException {
FormData formData1=new FormData(driver);
formData1.sendButtonClicking();
Thread.sleep(3000);


    }
    @Then("verify the message")
    public void verify_the_message() {
FormData formData3=new FormData(driver);
String actualErrorMessage=formData3.verifyingMessage();
        Assert.assertEquals("Thanks for your question. We'll send you an answer via email to kakarlakalyani123@gmail.com",actualErrorMessage);
    }

}
