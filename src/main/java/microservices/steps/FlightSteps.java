package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;

import static microservices.pages.Flight.*;

public class FlightSteps extends WebUI {

    @Step("Enter information book flight")
    public void enterInformationForFlight(String flightFrom, String flightTo, String fromDate, String toDate) {
        waitForElementIsPresence(txt_BookFlight, 10);
        clickElement(radiobtn_TwoWay);
        clearText(inp_From);
        sendKeys(inp_From, flightFrom);
        clickElement(opt_From);
        sleep(2000);
        clearText(inp_To);
        sendKeys(inp_To, flightTo);
        clickElement(opt_To);
        sleep(2000);

        clearText(inp_FromDate);
        sendKeys(inp_FromDate, fromDate);
        clearText(inp_ToDate);
        sendKeys(inp_ToDate, toDate);
        pressEnter(inp_ToDate);

        clickElement(inp_BusinessTrip);
        clickElement(opt_BusinessTrip);
        clickElement(btn_Search);

    }
}
