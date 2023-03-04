package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PojoClassCurrentAccounts extends BaseClass{
	
	public PojoClassCurrentAccounts() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/input[1]")
	private WebElement usernameLedgers;
	@FindBy(xpath = "/html/body/div[1]/div[1]/input[2]")
	private WebElement passwordLedgers;
	@FindBy(xpath = "/html/body/div[1]/div[1]/button[4]")
	private WebElement clickLogin;
	@FindBy(xpath = "//button[@data-state='crm']")
	private WebElement clickCrm;
	@FindBy(xpath = "/html/body/div[4]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[1]/a/img")
	private WebElement customerClick;
	@FindBy(xpath = "/html/body/div[4]/div/div[1]/div[2]/div/div/div/div/div/div/div/div/div[3]/div[4]/a/img")
	private WebElement developerClick;
	@FindBy(xpath = "//span[text()='Platforms']")
	private WebElement platformsClick;
	@FindBy(xpath = "//span[text()='EQL Fintech']")
	private WebElement eqlFinClick;
	@FindBy(xpath = "//span[text()='Current Accounts']")
	private WebElement currentAccountsClick;
	@FindBy(xpath="//button[text()='EQL Verified']")
	private WebElement eqlVerifiedTable;
	@FindBy(xpath ="//button[text()='Pre-Qualified']")
	private WebElement preQualifiedTable;
	@FindBy(xpath ="//button[text()='Unverified']")
	private WebElement unverifiedTable;
	@FindBy (xpath="//div[@class='kt-footer__copyright float-left']")
	private WebElement pageChecking;
	
	public WebElement getPageChecking() {
		return pageChecking;
	}
	public WebElement getEqlVerifiedTable() {
		return eqlVerifiedTable;
	}
	public WebElement getPreQualifiedTable() {
		return preQualifiedTable;
	}
	public WebElement getUnverifiedTable() {
		return unverifiedTable;
	}
	public WebElement getUsernameLedgers() {
		return usernameLedgers;
	}
	public WebElement getPasswordLedgers() {
		return passwordLedgers;
	}
	public WebElement getClickLogin() {
		return clickLogin;
	}
	public WebElement getClickCrm() {
		return clickCrm;
	}
	public WebElement getCustomerClick() {
		return customerClick;
	}
	public WebElement getDeveloperClick() {
		return developerClick;
	}
	public WebElement getPlatformsClick() {
		return platformsClick;
	}
	public WebElement getEqlFinClick() {
		return eqlFinClick;
	}
	public WebElement getCurrentAccountsClick() {
		return currentAccountsClick;
	}

}
