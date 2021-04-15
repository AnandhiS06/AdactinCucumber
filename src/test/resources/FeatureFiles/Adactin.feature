Feature: To validate Hotel Booking in AdactinHotel Page

  Background: 
    Given User is in Adactin Login Page

  @sanity
  Scenario Outline: Validate Booking
    When User logged in to Hotel Page and user in Search Hotel Page
      | Anandhi06 | Anandhi@123 |
    And User choosing "<location>", "<HotelName>", "<Roomtype>", "<num of rooms>", "<checkin date>", "<checkout date>", "<num of adults>" and "<num of children>"
    And User click search button and Available Hotels will be listed to the users
    And User Select Particular Hotel and click continue button and user in Payment page
    And User enters firstname, lastname, billing address,card number,card type,card expiry details and cvv number
      | Anandhi | Sankar | India | 1234567890123698 | 1 | 5 | 2022 | 1234 |
    And User click Book Now button and gets the confirm booking details
    Then User click Booked Iternary Page and validate the booking
    And User logout of the hotel page

    Examples: 
      | location  | HotelName    | Roomtype | num of rooms | checkin date | checkout date | num of adults | num of children |
      | Melbourne | Hotel Hervey |        4 | 2 - Two      | 10/04/2021   | 12/04/2021    |             2 |               0 |

  @smoke
  Scenario: To validate login by invalid username and password
    When User logged in to Hotel Page by invalid username and password
      | Anandhi | Anandhi123 |
