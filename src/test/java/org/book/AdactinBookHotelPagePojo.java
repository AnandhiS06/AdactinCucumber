package org.book;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdactinBookHotelPagePojo extends BaseClass{

		public AdactinBookHotelPagePojo() {
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
		
		@FindBy(xpath="//table")
		private List <WebElement> allTables;
		
		@FindBy(name="first_name")
		private WebElement txtFieldFirstName;
		
		@FindBy(name="last_name")
		private WebElement txtFieldLastName;
		
		@FindBy(name="address")
		private WebElement txtFieldAddress;
		
		@FindBy(name="cc_num")
		private WebElement txtFieldCreditCardNum;
		
		@FindBy(name="cc_type")
		private WebElement selectCreditCardType;
		
		@FindBy(name="cc_exp_month")
		private WebElement selectCardExpiryMonth;
		
		@FindBy(name="cc_exp_year")
		private WebElement selectCardExpiryYear;
		
		@FindBy(name="cc_cvv")
		private WebElement txtFieldCvvNum;
		
		@FindBy(name="book_now")
		private WebElement btnBookNow;
		
		@FindBy(name="cancel")
		private WebElement btnCancel;

		public WebElement getLnkBookedItinerary() {
			return lnkBookedItinerary;
		}

		public WebElement getLnkChangePassword() {
			return lnkChangePassword;
		}

		public WebElement getLnkSearchHotel() {
			return lnkSearchHotel;
		}

		public WebElement getLnkLogout() {
			return lnkLogout;
		}

		public WebElement getTxtFieldFirstName() {
			return txtFieldFirstName;
		}

		public WebElement getTxtFieldLastName() {
			return txtFieldLastName;
		}

		public WebElement getTxtFieldAddress() {
			return txtFieldAddress;
		}

		public WebElement getTxtFieldCreditCardNum() {
			return txtFieldCreditCardNum;
		}

		public WebElement getSelectCreditCardType() {
			return selectCreditCardType;
		}

		public WebElement getSelectCardExpiryMonth() {
			return selectCardExpiryMonth;
		}

		public WebElement getSelectCardExpiryYear() {
			return selectCardExpiryYear;
		}

		public WebElement getTxtFieldCvvNum() {
			return txtFieldCvvNum;
		}

		public List<WebElement> getAllTables() {
			return allTables;
		}

		public WebElement getBtnBookNow() {
			return btnBookNow;
		}

		public WebElement getBtnCancel() {
			return btnCancel;
		}
	}

