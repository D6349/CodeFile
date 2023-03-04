package org.stepdefinition;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.pojo.PojoClassCurrentAccounts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public PojoClassCurrentAccounts pCA;

	//public String target = "C:\\Users\\HP\\eclipse-workspace\\New folder\\CurrentAccounts\\Screenshot\\img";

	@Given("Customer can login the EQL site")
	public void customer_can_login_the_EQL_site() throws IOException {

		launchMutipleBrowser(readingProperty("browser"));

		launchUrl(readingProperty("url"));

	}

	@When("Customer enter their the creditinals of the page")
	public void customer_enter_their_the_creditinals_of_the_page() throws IOException {
		pCA = new PojoClassCurrentAccounts();
		enterText(pCA.getUsernameLedgers(), readingProperty("crm.username"));
		enterText(pCA.getPasswordLedgers(), readingProperty("crm.password"));

	}

	@When("Customer click the login button")
	public void customer_click_the_login_button() throws InterruptedException {

		pCA = new PojoClassCurrentAccounts();
		clickBtn(pCA.getClickLogin());
		ThreadSleep(7000);
		// javaScripClick(pCA.getCustomerClick());

		clickBtn(pCA.getCustomerClick());
		clickBtn(pCA.getPlatformsClick());
		// clickBtn(pCA.getCurrentAccountsClick());
		javaScripClick(pCA.getCurrentAccountsClick());
	}

	@When("Customer can select the their prefered table")
	public void customer_can_select_the_their_prefered_table() throws InterruptedException {

		// ThreadSleep(5000);
		windowsHandling(1);
		// chromeOptions();
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%';");
		pCA = new PojoClassCurrentAccounts();
		javaScripClick(pCA.getPreQualifiedTable());
	}

	@When("Customer can know the status of the applications")
	public void customer_can_know_the_status_of_the_applications() {

		// driver.findElement(By.xpath("//div[@class='kt-footer__copyright
		// float-left']"));
		pCA.getPageChecking();
		Assert.assertTrue("Current Accounts Page is Visible", true);

	}

}
