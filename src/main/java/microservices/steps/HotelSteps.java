package microservices.steps;

import Utils.CaptureUtils;
import Utils.WebUI;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static microservices.pages.Hotels.*;

public class HotelSteps extends WebUI {

    @Step("Enter information book hotel with one traveller")
    public void enterInformationForTrip(String location, String dateForm, String dateTo) {
        waitForElementIsPresence(txt_BookHotel, 10);
        clickElement(inp_Location);
        By opt_Location = replaceValueInXpath(xpath_location, "location", location);
        clickElement(opt_Location);

        clearText(inp_DateFrom);
        sendKeys(inp_DateFrom, dateForm);
        clearText(inp_DateTo);
        sendKeys(inp_DateTo, dateTo);
        pressEnter(inp_DateTo);

        clickElement(inp_BusinessTraveller);
        clickElement(opt_BusinessTraveller);
        clickElement(btn_Search);
    }

    @Step("Enter information book hotel with no traveller")
    public void enterInformationForTripWithNoTraveller(String location, String dateFrom, String dateTo) {
        waitForElementIsPresence(txt_BookHotel, 10);
        clickElement(inp_Location);
        By opt_Location = replaceValueInXpath(xpath_location, "location", location);
        clickElement(opt_Location);

        clearText(inp_DateFrom);
        sendKeys(inp_DateFrom, dateFrom);
        clearText(inp_DateTo);
        sendKeys(inp_DateTo, dateTo);
        pressEnter(inp_DateTo);

        clickElement(btn_Search);
        sleep(500);
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "No business traveller");
        Assert.assertFalse(elementIsPresent(error_msg_NoBusinessTraveller));
    }

    @Step("Enter information book hotel with 7 travellers")
    public void enterInformationForTripWithOverTravellers(String location, String dateFrom, String dateTo) {
        waitForElementIsPresence(txt_BookHotel, 10);
        clickElement(inp_Location);
        By opt_Location = replaceValueInXpath(xpath_location, "location", location);
        clickElement(opt_Location);


        clearText(inp_DateFrom);
        sendKeys(inp_DateFrom, dateFrom);
        clearText(inp_DateTo);
        sendKeys(inp_DateTo, dateTo);
        pressEnter(inp_DateTo);

        clickElement(inp_BusinessTraveller);
        for(int i = 1; i < 8; i ++) {
            By opt_BusinessTraveller = replaceValueInXpath(list_BusinessTraveller, "number", String.valueOf(i));
            clickElement(opt_BusinessTraveller);
        }
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Enter over 6 travellers");
        Assert.assertTrue(elementIsPresent(error_msg_OverBusinessTraveller));
    }

    @Step("Enter information book hotel with 6 travellers")
    public void enterInformationForTripWith6Travellers(String location, String dateFrom, String dateTo) {
        waitForElementIsPresence(txt_BookHotel, 10);
        clickElement(inp_Location);
        By opt_Location = replaceValueInXpath(xpath_location, "location", location);
        clickElement(opt_Location);

        clearText(inp_DateFrom);
        sendKeys(inp_DateFrom, dateFrom);
        clearText(inp_DateTo);
        sendKeys(inp_DateTo, dateTo);
        pressEnter(inp_DateTo);

        clickElement(inp_BusinessTraveller);
        for(int i = 1; i < 7; i ++) {
            By opt_BusinessTraveller = replaceValueInXpath(list_BusinessTraveller, "number", String.valueOf(i));
            clickElement(opt_BusinessTraveller);
        }
        clickElement(btn_Search);
    }

    @Step("Enter information book hotel and choose appointed hotel")
    public void enterInformationAndChooseAppointedHotel() {
        waitForElementIsPresence(txt_BookHotel, 10);
        clickElement(btn_ChooseAppointedHotel);
    }
}
