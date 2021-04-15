package org.selhotel;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSearchHotelPagePojo extends BaseClass {

		public AdactinSearchHotelPagePojo() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[text()='Booked Itinerary']")
		private WebElement lnkBookedItinerary;
		
		@FindBy(xpath="//a[text()='Change Password']")
		private WebElement lnkChangePassword;
		
		@FindBy(xpath="//a[text()='Search Hotel']")
		private WebElement lnkSearchHotel;
		
		@FindBy(xpath="//a[text()='Logout']")
		private WebElement lnkLogout;
		
		@FindBy(id="radiobutton_0")
		private WebElement radioBtnSelectHotel;
		
		@FindBy(id="continue")
		private WebElement btnContinue;
		
		@FindBy(id="cancel")
		private WebElement btnCancel;
		

		public WebElement getLnkBookedItinerary() {
			return lnkBookedItinerary;
		}

		public WebElement getLnkChangePassword() {
			return lnkChangePassword;
		}

		public WebElement getLnkLogout() {
			return lnkLogout;
		}

		public WebElement getRadioBtnSelectHotel() {
			return radioBtnSelectHotel;
		}
		
		public WebElement getBtnContinue() {
			return btnContinue;
		}

		public WebElement getBtnCancel() {
			return btnCancel;
		}
		

	}

