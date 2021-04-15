package org.booked;

import java.util.List;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookedItineraryPagePojo extends BaseClass{

	public AdactinBookedItineraryPagePojo() {
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
	
	@FindBy(id="order_id_text")
	private WebElement txtFieldSearchOrderId;
	
	@FindBy(xpath="//table")
	private List<WebElement> allTables;
	
	@FindBy(xpath="(//table)[5]//tr")
	private List<WebElement> bookedHotelLists;
	
	@FindBy(xpath="td[2]//input")
	private WebElement orderNum;
	
	@FindBy(id="search_hotel")
	private WebElement btnSearchHotel;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement btnGo;
	
	@FindBy(xpath="//input[@value='Cancel Selected']")
	private WebElement btnCancelSelected;
	
	@FindBy(id="logout")
	private WebElement btnLogout;

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

	public WebElement getTxtFieldSearchOrderId() {
		return txtFieldSearchOrderId;
	}

	public List<WebElement> getAllTables() {
		return allTables;
	}

	public WebElement getBtnSearchHotel() {
		return btnSearchHotel;
	}

	public WebElement getBtnCancelSelected() {
		return btnCancelSelected;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}
	
	public WebElement getBtnGo() {
		return btnGo;
	}

	public List<WebElement> getBookedHotelLists() {
		return bookedHotelLists;
	}

	public WebElement getOrderNum() {
		return orderNum;
	}

}
