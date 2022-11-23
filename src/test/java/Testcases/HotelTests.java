package Testcases;

import Bases.BaseTest;
import Utils.ExcelConfig;
import Utils.PropertiesFile;
import microservices.steps.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HotelTests extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/data.xlsx");
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    DashboardSteps dashboardSteps = new DashboardSteps();
    HotelSteps hotelSteps = new HotelSteps();
    HotelListsSteps hotelListsSteps = new HotelListsSteps();
    BookHotelSteps bookHotelSteps = new BookHotelSteps();
    BookHotelDetailsSteps bookHotelDetailsSteps = new BookHotelDetailsSteps();
    PaymentSteps paymentSteps = new PaymentSteps();
    BookCompleteSteps bookCompleteSteps = new BookCompleteSteps();
    int sheetIndexTestCasesHotel = 2;

    @BeforeMethod
    public void preTest() {
        String emailLogin = PropertiesFile.getPropValue("email");
        String password = PropertiesFile.getPropValue("password");
        loginPageSteps.loginWithCredentials(emailLogin, password);
        dashboardSteps.verifyLoginSuccessfully();
    }

    @DataProvider
    public Object[][] dataBookHotel() {
        return excelConfig.data(sheetIndexTestCasesHotel);
    }

    @Test(dataProvider = "dataBookHotel")
    public void bookHotel(String location, String dateFrom, String dateTo) {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationForTrip(location, dateFrom, dateTo);
        hotelListsSteps.verifyRedirectToHotelList();
        hotelListsSteps.clickViewHotel();
        bookHotelSteps.switchToBookHotel();
        bookHotelSteps.verifyNotChooseRoom();
        bookHotelSteps.bookRoom();
        bookHotelSteps.verifyBookedRoom();
        bookHotelSteps.clickBook();
        bookHotelDetailsSteps.verifyRedirectToBookDetail();
        bookHotelDetailsSteps.attachFile();
        bookHotelDetailsSteps.verifyAttachSuccessfully();
        bookHotelDetailsSteps.addNote();
        paymentSteps.verifyRedirectToPayment();
        paymentSteps.checkOverLimit();
        bookCompleteSteps.verifyPaymentForHotelSuccessfully();
    }

    @Test
    public void bookHotelWithNoTraveller() {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationForTripWithNoTraveller("Hà Nội", "11-11-2022", "12-11-2022");
    }

    @Test
    public void bookHotelWithMultipleTravellers() {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationForTripWithOverTravellers("Hà Nội", "11-11-2022", "12-11-2022");
    }

    @Test
    public void bookHotelWith6Travellers() {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationForTripWith6Travellers("Hà Nội", "11-11-2022", "12-11-2022");
        hotelListsSteps.verifyRedirectToHotelList();
        hotelListsSteps.clickViewHotel();
        bookHotelSteps.switchToBookHotel();
        bookHotelSteps.verifyNotChooseRoom();
        bookHotelSteps.bookRoom();
        bookHotelSteps.verifyBookedRoom();
        bookHotelSteps.clickBook();
        bookHotelSteps.verifyExceedCapacity();
    }

    @Test
    public void bookErrorRoomNoBed() {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationAndChooseAppointedHotel();
        bookHotelSteps.switchToBookHotel();
        bookHotelSteps.verifyNotChooseRoom();
        bookHotelSteps.fillInformation();
        bookHotelSteps.bookRoomWithNoBed();
        bookHotelSteps.verifyBookedRoomNoBed();
        bookHotelSteps.clickBook();
        bookHotelSteps.verifyErrorHotel();
    }

    @Test
    public void BookErrorTotalRoom() {
        dashboardSteps.clickBookHotel();
        hotelSteps.enterInformationAndChooseAppointedHotel();
        bookHotelSteps.switchToBookHotel();
        bookHotelSteps.verifyNotChooseRoom();
        bookHotelSteps.fillInformation();
        bookHotelSteps.bookMoreRoom();
        bookHotelSteps.clickBook();
        bookHotelSteps.verifyInvalidNumberRoom();
    }
}
