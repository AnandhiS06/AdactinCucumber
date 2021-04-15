package org.confirm;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdactinBookingConfirmPagePojo extends BaseClass {

	public AdactinBookingConfirmPagePojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement lnkBookedItinerary;
	
	@FindBy(xpath="//a[text()='Change Password']")
	private WebElement lnkChangePassword;
	
	@FindBy(xpath="//a[text()='Search Hotel']")
	private WebElement lnkSearchHotel;
	
	@FindBy(xpath="//table")
	private List<WebElement> allTables;
	
	@FindBy(id="order_no")
	private WebElement orderId;

	@FindBy(id="search_hotel")
	private WebElement btnSearchHotel;
	
	@FindBy(id="my_itinerary")
	private WebElement btnMyItinerary;
	
	@FindBy(id="logout")
	private WebElement btnLogout;

	public WebElement getOrderId() {
		return orderId;
	}

	public WebElement getLnkBookedItinerary() {
		return lnkBookedItinerary;
	}

	public WebElement getLnkChangePassword() {
		return lnkChangePassword;
	}

	public WebElement getLnkSearchHotel() {
		return lnkSearchHotel;
	}
	
	public List<WebElement> getAllTables() {
		return allTables;
	}

	public WebElement getBtnSearchHotel() {
		return btnSearchHotel;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}
}
