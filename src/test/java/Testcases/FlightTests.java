package Testcases;

import Bases.BaseTest;
import Utils.ExcelConfig;
import Utils.PropertiesFile;
import microservices.steps.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FlightTests extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/data.xlsx");
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    DashboardSteps dashboardSteps = new DashboardSteps();
    FlightSteps flightSteps = new FlightSteps();
    FlightListSteps flightListSteps = new FlightListSteps();
    BookFlightDetailsSteps bookFlightDetailsSteps = new BookFlightDetailsSteps();
    PaymentSteps paymentSteps = new PaymentSteps();
    BookCompleteSteps bookCompleteSteps = new BookCompleteSteps();
    int sheetIndexTestCasesFlight = 3;

    @BeforeMethod
    public void preTest() {
        String emailLogin = PropertiesFile.getPropValue("email");
        String password = PropertiesFile.getPropValue("password");
        loginPageSteps.loginWithCredentials(emailLogin, password);
        dashboardSteps.verifyLoginSuccessfully();
    }

    @DataProvider
    public Object[][] dataBookFlight() {
        return excelConfig.data(sheetIndexTestCasesFlight);
    }

    @Test(dataProvider = "dataBookFlight")
    public void bookFlight(String flightFrom, String flightTo, String fromDate, String toDate) {
        dashboardSteps.clickBookFlight();
        flightSteps.enterInformationForFlight(flightFrom, flightTo, fromDate, toDate);
        flightListSteps.verifyRedirectToFlightList();
        flightListSteps.chooseFlight();
        flightListSteps.clickBookFlight();
        bookFlightDetailsSteps.verifyRedirectToBookFlightDetail();
        bookFlightDetailsSteps.clickContinue();
        paymentSteps.waitForKeepSeatSuccessfully();
        paymentSteps.conductPayment();
        paymentSteps.checkOverLimit();
        bookCompleteSteps.verifyPaymentForFlightSuccessfully();
    }

    @Test
    public void bookFlightWithInvalidBusinessTraveller() {
        dashboardSteps.logOut();
        loginPageSteps.logoutSuccessfully();
        loginPageSteps.loginWithCredentials("approver@yopmail.com", "12345678");
        dashboardSteps.verifyLoginSuccessfully();
        dashboardSteps.clickBookFlight();
        flightSteps.enterInformationForFlight("Hà Nội", "DAD", "11-11-2022", "12-11-2022");
        flightListSteps.verifyRedirectToFlightList();
        flightListSteps.chooseFlight();
        flightListSteps.clickBookFlight();
        bookFlightDetailsSteps.verifyRedirectToBookFlightDetail();
        bookFlightDetailsSteps.clickContinue();
        bookFlightDetailsSteps.verifyInvalidPassenger();
    }

}
