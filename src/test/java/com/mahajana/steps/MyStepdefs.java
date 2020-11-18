package com.mahajana.steps;

import com.mahajana.functions.DriverFactory;
import com.mahajana.functions.EnvironmentContext;
import com.mahajana.functions.PageFileParser;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    private WebDriver driver = new DriverFactory().getDriver();
    private EnvironmentContext environmentContext = new EnvironmentContext();
    private PageFileParser page = new PageFileParser();
    private Scenario myScenario;

    @Given("^user Access Task manager application via browser$")
    public void accessTaskManagerUrl() throws Throwable {
        driver.get(environmentContext.getProperty("taskmanager.url.dev"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.loadPage("LogIn");
        Assert.assertTrue(driver.getPageSource().contains("Login to manage your tasks"));
   }

    @Given("^user Access Task manager landing page$")
    public void accessTaskManagerLandingPage() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.loadPage("My day");
        Assert.assertTrue(driver.getPageSource().contains("My day"));
    }

    @When("^user inputs \"([^\"]*)\" in the field \"([^\"]*)\"$")
    public void userInputsInTheField(String keyword, String field) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id(page.getElementSelector(field))).sendKeys(keyword);
         //driver.findElement(By.name(page.getElementSelector(field))).sendKeys(keyword);
    }

    @When("^user enter tasks details with taskTitle \"([^\"]*)\" ,taskDescription \"([^\"]*)\" and taskDueDate \"([^\"]*)\"$")
    public void user_enter_tasks_details_with_taskTitle_taskDescription_and_taskDueDate(String taskTitle, String taskDescription, String taskDueDate) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("^user click on \"([^\"]*)\" Page$")
    public void user_click_on_Page(String taskPage)  {
        driver.findElement(By.xpath("//a[contains(@class,'sidenav-item')]//div[contains(text(),'"+taskPage +"')]")).click();
        Assert.assertTrue(driver.getPageSource().contains(taskPage));
    }

    @When("^user make that task as Important$")
    public void makeTaskAsImportant(){
        driver.findElement(By.className(page.getElementSelector("Important"))).click();
    }

    @Then("^user click \"([^\"]*)\" button$")
    public void userClick(String field) throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(page.getElementSelector(field)) ).click();

    }
    @Then("^user Remove the \"([^\"]*)\"$")
    public void removeTask(String taskTitle)
    {
        driver.findElement(By.xpath("//mat-card[contains(@class,'task-card')]//span[contains(text(),'"+taskTitle +"')]/following-sibling::mat-icon[contains(@class,'remove-icon')]")).click();
    }

    @Then("^user should see \"([^\"]*)\" on the page$")
    public void userShouldSeeOnThePage(String text) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @Then("^user should not see see \"([^\"]*)\" on the page$")
    public void userShouldNotSeeOnThePage(String text) throws Throwable {
        boolean isTaskTextPresent;
        isTaskTextPresent = driver.getPageSource().contains(text);
        Assert.assertFalse(isTaskTextPresent);
    }

    @Given("^user lands on \"([^\"]*)\" home page$")
    public void userLandsOnHomePage(String homepage) throws Throwable {
        driver.get(environmentContext.getProperty(homepage+".url"));
        page.loadPage("home page");
    }

    @Then("^user should land on \"([^\"]*)\" page$")
    public void userShouldLandOnPage(String pageName) {
        page.loadPage(pageName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains(pageName));
    }

    @After
    public void afterScenario (Scenario scenario) {
       new DriverFactory().destoryDriver();
    }

}
