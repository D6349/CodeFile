package org.step;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pojo.PojoLedgersLogin;
import org.utilities.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepperClass extends BaseClass{

	public static PojoLedgersLogin plL;

	@Given("user can login the site")
	public void user_can_login_the_site() throws IOException, InterruptedException {

	launchBrowser(readingProperty("browser"));
	loadUrl(readingProperty("url"));
	//driver.findElement(By.xpath("//a[text()='Login']")).click();
	//driver.findElement(By.xpath("/html/body/div[1]/div[1]/input[1]")).sendKeys("deena.dayalanh@indiafilings.com");
	
	//sleepThread(5000);

	}

	@When("user can enter the username and password")
	public void user_can_enter_the_username_and_password() throws InterruptedException, IOException {
		
		plL= new PojoLedgersLogin();
		elementClick(plL.getLoginClk());
		enterText(plL.getLoginLs(), readingProperty("ld.username"));
		enterText(plL.getPasswordLs(), readingProperty("ld.password"));
		
	}

	@When("user can enter the login button")
	public void user_can_enter_the_login_button() {
		
		//driver.findElement(By.xpath("//button[@class='btn login-btn']")).click();
		elementClick(plL.getBtnClk());

	}

	@Then("user can check site is opened or not.")
	public void user_can_check_site_is_opened_or_not() {
		
		

	}

}
