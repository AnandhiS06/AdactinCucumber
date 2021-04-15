package org.login;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPagePojo extends BaseClass{

		public AdactinLoginPagePojo() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(name="username")
		private WebElement txtUserName;
		
		@FindBy(name="password")
		private WebElement txtPass;
		
		@FindBy(id="login")
		private WebElement btnLogin;
		
		@FindBy(xpath="//a[text()='New User Register Here']")
		private WebElement btnRegisterNewUser;
		
		@FindBy(xpath="//a[text()='Forgot Password?']")
		private WebElement btnForgotPass;

		public WebElement getTxtUserName() {
			return txtUserName;
		}

		public WebElement getTxtPass() {
			return txtPass;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}

		public WebElement getBtnRegisterNewUser() {
			return btnRegisterNewUser;
		}

		public WebElement getBtnForgotPass() {
			return btnForgotPass;
		}
	}