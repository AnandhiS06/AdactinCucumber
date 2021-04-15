package org.create;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdactinCreateAccountPagePojo extends BaseClass{

		public AdactinCreateAccountPagePojo() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="re_password")
		private WebElement txtConfirmPass;
		
		@FindBy(name="full_name")
		private WebElement txtFirstName;
		
		@FindBy(name="email_add")
		private WebElement txtEmailId;
		@FindBys({
			@FindBy(name="username"),
			@FindBy(xpath="//input[@type='text']")
			})
		private WebElement txtUserName;
		
		@FindBys({
			@FindBy(name="password"),
			@FindBy(xpath="//input[@type='password']")
			})
		private WebElement txtPass;
		
		

		@FindAll({
			@FindBy(name="tnc_box"),
			@FindBy(xpath="//input[@type='checkbox']")
			})
		private WebElement btnTermsAndConditions;
		
		@FindAll({
			@FindBy(name="submit"),
			@FindBy(id="submit"),
			@FindBy(xpath="//input[@value='Register']")
			})
		private WebElement btnRegister;
		
		public WebElement getTxtUserName() {
			return txtUserName;
		}

		public WebElement getTxtPass() {
			return txtPass;
		}

		public WebElement getTxtConfirmPass() {
			return txtConfirmPass;
		}

		public WebElement getTxtFirstName() {
			return txtFirstName;
		}

		public WebElement getTxtEmailId() {
			return txtEmailId;
		}

		public WebElement getBtnTermsAndConditions() {
			return btnTermsAndConditions;
		}

		public WebElement getBtnRegister() {
			return btnRegister;
		}
		
	}

