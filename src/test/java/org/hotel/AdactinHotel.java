package org.hotel;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.book.AdactinBookHotelPagePojo;
import org.booked.AdactinBookedItineraryPagePojo;
import org.confirm.AdactinBookingConfirmPagePojo;
import org.login.AdactinLoginPagePojo;
import org.openqa.selenium.WebElement;
import org.selhotel.AdactinSearchHotelPagePojo;
import org.welcome.AdactinWelcomePagePojo;

public class AdactinHotel extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		launchChromeBrowser();
		launchUrl("http://adactinhotelapp.com/");
		maximizeWindow();
		
		AdactinLoginPagePojo aLogin = new AdactinLoginPagePojo();
		//Login to the page
		enterText(aLogin.getTxtUserName(), readExcelParticualData("AdactinHotel", "LoginDetails", 1, 0));
		enterTextByJSE(aLogin.getTxtPass(), readExcelParticualData("AdactinHotel", "LoginDetails", 1, 1));
		clickBtn(aLogin.getBtnLogin());
		waitWithThread();

		AdactinWelcomePagePojo aWelcomePage=new AdactinWelcomePagePojo();
		clickBtn(aWelcomePage.getLnkSearchHotel());
		Thread.sleep(2000);
		selectValue(aWelcomePage.getSelectLocation(), readExcelParticualData("AdactinHotel", "SearchHotel", 1, 0));
		selectText(aWelcomePage.getSelectHotel(), readExcelParticualData("AdactinHotel", "SearchHotel", 1, 1));
		selectIndex(aWelcomePage.getSelectRoomType(), 4);
		
		checkMultipleOptions(aWelcomePage.getSelectRoomNos());
		selectText(aWelcomePage.getSelectRoomNos(), readExcelParticualData("AdactinHotel", "SearchHotel", 1, 3));
		
		clearTextField(aWelcomePage.getTxtCheckinDate());
		clearTextField(aWelcomePage.getTxttCheckOutDate());
		
		enterText(aWelcomePage.getTxtCheckinDate(), readExcelParticualData("AdactinHotel", "SearchHotel", 1, 4));
		enterText(aWelcomePage.getTxttCheckOutDate(), readExcelParticualData("AdactinHotel", "SearchHotel", 1, 5));
		
		selectIndex(aWelcomePage.getSelectTotalAdult(), 2);
		selectIndex(aWelcomePage.getSelectTotalChild(), 0);
		
		clickBtn(aWelcomePage.getBtnSearch());
		waitWithThread();
		
		AdactinSearchHotelPagePojo aSelectHotel=new AdactinSearchHotelPagePojo();
		clickBtn(aSelectHotel.getRadioBtnSelectHotel());
		clickBtn(aSelectHotel.getBtnContinue());
		waitWithThread();
		
		AdactinBookHotelPagePojo aBook=new AdactinBookHotelPagePojo();
		
		enterText(aBook.getTxtFieldFirstName(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 0));
		enterText(aBook.getTxtFieldLastName(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 1));
		enterText(aBook.getTxtFieldAddress(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 2));
		enterText(aBook.getTxtFieldCreditCardNum(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 3));
		selectIndex(aBook.getSelectCreditCardType(), 1);
		selectValue(aBook.getSelectCardExpiryMonth(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 5));
		selectText(aBook.getSelectCardExpiryYear(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 6));
		enterText(aBook.getTxtFieldCvvNum(), readExcelParticualData("AdactinHotel", "BookHotel", 1, 7));
		
		clickBtn(aBook.getBtnBookNow());
		
		Thread.sleep(5000);
		AdactinBookingConfirmPagePojo aConfirmPage=new AdactinBookingConfirmPagePojo();
		System.out.println("Booking Details");
		WebElement confirmTable = aConfirmPage.getAllTables().get(3);
		System.out.println("Order Id: "+printParticularInputValueInTable(confirmTable,"order_no"));
		writeExcel("AdactinHotelOrderId", "ConfirmPage", 0, 0,"Order Num");
		writeExcel("AdactinHotelOrderId", "ConfirmPage", 1, 0,printParticularInputValueInTable(confirmTable,"order_no"));
		
	
		snapshot("Booked Itinerary");
		clickBtn(aConfirmPage.getBtnMyItinerary());
		
		
		AdactinBookedItineraryPagePojo aBookedPage=new AdactinBookedItineraryPagePojo();
		clickBtn(aBookedPage.getLnkBookedItinerary());
		waitWithThread();
		
		clickBtn(aConfirmPage.getBtnLogout());
		closeBrowser();	
	}
	
}
