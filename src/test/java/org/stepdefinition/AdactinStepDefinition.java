package org.stepdefinition;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.baseclass.BaseClass;
import org.book.AdactinBookHotelPagePojo;
import org.booked.AdactinBookedItineraryPagePojo;
import org.confirm.AdactinBookingConfirmPagePojo;
import org.junit.Assert;
import org.login.AdactinLoginPagePojo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selhotel.AdactinSearchHotelPagePojo;
import org.welcome.AdactinWelcomePagePojo;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactinStepDefinition extends BaseClass {

	public AdactinLoginPagePojo aLogin;
	public AdactinWelcomePagePojo aWelcomePage;
	public AdactinSearchHotelPagePojo aSelectHotel;
	public AdactinBookHotelPagePojo aBook;
	public AdactinBookingConfirmPagePojo aConfirmPage;
	public AdactinBookedItineraryPagePojo aBookedPage;
	public String orderId;

	@Given("User is in Adactin Login Page")
	public void user_is_in_Adactin_Login_Page() {

		launchUrl("http://adactinhotelapp.com/");
	}

	@When("User logged in to Hotel Page and user in Search Hotel Page")
	public void user_logged_in_to_Hotel_Page_and_user_in_Search_Hotel_Page(DataTable d) throws InterruptedException {
		aLogin = new AdactinLoginPagePojo();

		List<String> l1 = d.asList();

		enterText(aLogin.getTxtUserName(), l1.get(0));
		enterTextByJSE(aLogin.getTxtPass(), l1.get(1));
		clickBtn(aLogin.getBtnLogin());
		waitWithThread();
	}

	@When("User choosing {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_choosing_and(String loc, String hotel, String roomType, String roomnos, String indate,
			String outdate, String adultCount, String childCount) throws IOException {

		aWelcomePage = new AdactinWelcomePagePojo();

		// selectValue(aWelcomePage.getSelectLocation(), loc);
		// selectText(aWelcomePage.getSelectHotel(), hotel);
		// selectIndex(aWelcomePage.getSelectRoomType(), Integer.parseInt(roomType));
		//
		// checkMultipleOptions(aWelcomePage.getSelectRoomNos());
		// selectText(aWelcomePage.getSelectRoomNos(), roomnos);
		//
		// clearTextField(aWelcomePage.getTxtCheckinDate());
		// clearTextField(aWelcomePage.getTxttCheckOutDate());
		//
		// enterText(aWelcomePage.getTxtCheckinDate(), indate);
		// enterText(aWelcomePage.getTxttCheckOutDate(), outdate);
		//
		// selectIndex(aWelcomePage.getSelectTotalAdult(),
		// Integer.parseInt(adultCount));
		// selectIndex(aWelcomePage.getSelectTotalChild(),
		// Integer.parseInt(childCount));

		Map<String, String> allCells = readExcelCompleteCellsInParticularRow("AdactinHotel -Cucumber", "HotelSearch",
				"Hotel Hervey");
		selectValue(aWelcomePage.getSelectLocation(), allCells.get("Location"));
		selectText(aWelcomePage.getSelectHotel(), allCells.get("HotelName"));
		selectIndex(aWelcomePage.getSelectRoomType(), Integer.parseInt(allCells.get("RoomType")));

		checkMultipleOptions(aWelcomePage.getSelectRoomNos());
		selectText(aWelcomePage.getSelectRoomNos(), allCells.get("RoomNum"));

		clearTextField(aWelcomePage.getTxtCheckinDate());
		clearTextField(aWelcomePage.getTxttCheckOutDate());

		enterText(aWelcomePage.getTxtCheckinDate(), allCells.get("CheckInDate"));
		enterText(aWelcomePage.getTxttCheckOutDate(), allCells.get("CheckOutDate"));

		selectIndex(aWelcomePage.getSelectTotalAdult(), Integer.parseInt(allCells.get("TotalAdult")));
		selectIndex(aWelcomePage.getSelectTotalChild(), Integer.parseInt(allCells.get("TotalChild")));

	}

	@When("User click search button and Available Hotels will be listed to the users")
	public void user_click_search_button_and_Available_Hotels_will_be_listed_to_the_users()
			throws InterruptedException {
		clickBtn(aWelcomePage.getBtnSearch());
		waitWithThread();
	}

	@When("User Select Particular Hotel and click continue button and user in Payment page")
	public void user_Select_Particular_Hotel_and_click_continue_button_and_user_in_Payment_page()
			throws InterruptedException {
		aSelectHotel = new AdactinSearchHotelPagePojo();
		clickBtn(aSelectHotel.getRadioBtnSelectHotel());
		clickBtn(aSelectHotel.getBtnContinue());
		waitWithThread();
	}

	@When("User enters firstname, lastname, billing address,card number,card type,card expiry details and cvv number")
	public void user_enters_firstname_lastname_billing_address_card_number_card_type_card_expiry_details_and_cvv_number(
			DataTable d) {
		aBook = new AdactinBookHotelPagePojo();

		List<String> l2 = d.asList();

		enterText(aBook.getTxtFieldFirstName(), l2.get(0));
		enterText(aBook.getTxtFieldLastName(), l2.get(1));
		enterText(aBook.getTxtFieldAddress(), l2.get(2));
		enterText(aBook.getTxtFieldCreditCardNum(), l2.get(3));
		selectIndex(aBook.getSelectCreditCardType(), Integer.parseInt(l2.get(4)));
		selectValue(aBook.getSelectCardExpiryMonth(), l2.get(5));
		selectText(aBook.getSelectCardExpiryYear(), l2.get(6));
		enterText(aBook.getTxtFieldCvvNum(), l2.get(7));
	}

	@When("User click Book Now button and gets the confirm booking details")
	public void user_click_Book_Now_button_and_gets_the_confirm_booking_details()
			throws InterruptedException, IOException {
		clickBtn(aBook.getBtnBookNow());

		Thread.sleep(5000);
		aConfirmPage = new AdactinBookingConfirmPagePojo();
		System.out.println("Booking Details");
		WebElement confirmTable = aConfirmPage.getAllTables().get(3);
		orderId = aConfirmPage.getOrderId().getAttribute("value");
		// orderId = printParticularInputValueInTable(confirmTable, "order_no");
		System.out.println("Order Id: " + orderId);
		snapshot("Booked Itinerary");
	}

	@Then("User click Booked Iternary Page and validate the booking")
	public void user_click_Booked_Iternary_Page_and_validate_the_booking() throws InterruptedException {
		clickBtn(aConfirmPage.getBtnMyItinerary());

		aBookedPage = new AdactinBookedItineraryPagePojo();
		clickBtn(aBookedPage.getLnkBookedItinerary());
		waitWithThread();
		String orderDetail = "";

		for (int i = 1; i < aBookedPage.getBookedHotelLists().size(); i++) {
			List<WebElement> bookedHotels = aBookedPage.getBookedHotelLists();
			WebElement bookedRow = bookedHotels.get(i);
			WebElement orderNum = bookedRow.findElement(By.xpath("td[2]//input"));
			orderDetail = getTextFromTextField(orderNum);

		}
		System.out.println("Order Details in Booked Itinerary Page :" + orderDetail);
		Assert.assertEquals(orderId, orderDetail);
		System.out.println("Booking Validated");
	}

	@Then("User logout of the hotel page")
	public void user_logout_of_the_hotel_page() {
		clickBtn(aBookedPage.getLnkLogout());
	}

	@When("User logged in to Hotel Page by invalid username and password")
	public void user_logged_in_to_Hotel_Page_by_invalid_username_and_password(DataTable d) throws InterruptedException {
		aLogin = new AdactinLoginPagePojo();

		List<String> l1 = d.asList();

		enterText(aLogin.getTxtUserName(), l1.get(0));
		enterTextByJSE(aLogin.getTxtPass(), l1.get(1));
		clickBtn(aLogin.getBtnLogin());
		waitWithThread();
	}
}
