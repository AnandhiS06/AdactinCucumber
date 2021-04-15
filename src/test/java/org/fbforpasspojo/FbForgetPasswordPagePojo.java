package org.fbforpasspojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbForgetPasswordPagePojo extends BaseClass{

	public FbForgetPasswordPagePojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="identify_email")
	private WebElement txtMobNum;
	
	@FindBy(xpath="//a[contains(text(),'Cancel')]")
	private WebElement lnkCancel;
	
	@FindBy(id="did_submit")
	private WebElement btnSubmit;
	
	@FindBy(xpath="//a[contains(text(),'Forgotten account?')]")
	private WebElement lnkForgetAccount;
	
	@FindBy(xpath="//div[contains(text(),'Please identify this account another way')]")
	private WebElement txtErrorMsg;

	public WebElement getTxtMobNum() {
		return txtMobNum;
	}

	public WebElement getLnkCancel() {
		return lnkCancel;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getLnkForgetAccount() {
		return lnkForgetAccount;
	}

	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}
}
