package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoLedgers extends BaseClass{
	
public PojoLedgers() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginClk;
	@FindBy(xpath ="/html/body/div[1]/div[1]/input[1]")
	private WebElement loginLs;
	@FindBy(xpath ="/html/body/div[1]/div[1]/input[2]")
	private WebElement passwordLs;
	@FindBy(xpath ="//button[@class='btn login-btn']")
	private WebElement btnClk;
	
	public WebElement getLoginClk() {
		return loginClk;
	}
	public WebElement getLoginLs() {
		return loginLs;
	}
	public WebElement getPasswordLs() {
		return passwordLs;
	}
	public WebElement getBtnClk() {
		return btnClk;
	}

}
