package org.fbhomepojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbHomePagePojo extends BaseClass {

	public FbHomePagePojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement txtUser;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(name = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[contains(text(),'Forgotten password?')]")
	private WebElement lnkForgotPassword;

	@FindBy(xpath = "//a[contains(text(),'Create New Account')]")
	private WebElement lnkCreateNewAcc;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLnkForgotPassword() {
		return lnkForgotPassword;
	}

	public WebElement getLnkCreateNewAcc() {
		return lnkCreateNewAcc;
	}

}
