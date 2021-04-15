package org.welcome;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinWelcomePagePojo extends BaseClass {

	public AdactinWelcomePagePojo() {
		PageFactory.initElements(driver, this);
	}
		//Welcome page
		
		@FindBy(xpath="//a[text()='Booked Itinerary']")
		private WebElement lnkBookedItinerary;
		
		@FindBy(xpath="//a[text()='Change Password']")
		private WebElement lnkChangePassword;
		
		@FindBy(xpath="//a[text()='Search Hotel']")
		private WebElement lnkSearchHotel;
		
		public WebElement getLnkSearchHotel() {
			return lnkSearchHotel;
		}

		public WebElement getTxtCheckOutDate() {
			return txtCheckOutDate;
		}

		@FindBy(xpath="//a[text()='Logout']")
		private WebElement lnkLogout;
		
		//search Hotel Field
		@FindBy(id="location")
		private WebElement selectLocation;
		
		@FindBy(id="hotels")
		private WebElement selectHotel;
		
		@FindBy(id="room_type")
		private WebElement selectRoomType;
		
		@FindBy(id="room_nos")
		private WebElement selectRoomNos;
		
		@FindBy(id="datepick_in")
		private WebElement txtCheckinDate;
		
		@FindBy(id="datepick_out")
		private WebElement txtCheckOutDate;
		
		@FindBy(id="adult_room")
		private WebElement selectTotalAdult;
		
		@FindBy(id="child_room")
		private WebElement selectTotalChild;
		
		@FindBy(xpath="//input[@value='Search']")
		private WebElement btnSearch;
		
		@FindBy(id="Reset")
		private WebElement btnReset;

		public WebElement getLnkBookedItinerary() {
			return lnkBookedItinerary;
		}

		public WebElement getLnkChangePassword() {
			return lnkChangePassword;
		}

		public WebElement getLnkLogout() {
			return lnkLogout;
		}

		public WebElement getSelectLocation() {
			return selectLocation;
		}

		public WebElement getSelectHotel() {
			return selectHotel;
		}

		public WebElement getSelectRoomType() {
			return selectRoomType;
		}

		public WebElement getSelectRoomNos() {
			return selectRoomNos;
		}

		public WebElement getTxtCheckinDate() {
			return txtCheckinDate;
		}

		public WebElement getTxttCheckOutDate() {
			return txtCheckOutDate;
		}

		public WebElement getSelectTotalAdult() {
			return selectTotalAdult;
		}

		public WebElement getSelectTotalChild() {
			return selectTotalChild;
		}

		public WebElement getBtnSearch() {
			return btnSearch;
		}
		
		public WebElement getBtnReset() {
			return btnReset;
		}
		
		
	}

