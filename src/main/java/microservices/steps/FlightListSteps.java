package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.FlightLists.*;

public class FlightListSteps extends WebUI {

    @Step
    public void verifyRedirectToFlightList() {
        waitForElementIsPresence(btn_ChooseFlight, 60);
        Assert.assertTrue(elementIsPresent(btn_ChooseFlight));
    }

    @Step
    public void chooseFlight() {
        clickElement(radiobtn_FlightEarliest);
        sleep(4000);
        String flightFrom = getText(txt_FlightAddress);
        Assert.assertTrue(flightFrom.contains("Hà Nội"));
        clickElement(btn_ChooseFlight);
        sleep(3000);
        String flightTo = getText(txt_FlightAddress);
        Assert.assertTrue(flightTo.contains("Đà Nẵng"));
        clickElement(btn_ChooseFlight);
    }

    @Step
    public void clickBookFlight() {
        waitForElementIsPresence(btn_Book, 5);
        Assert.assertTrue(elementIsPresent(btn_Book));
        clickElement(btn_Book);
        Assert.assertFalse(elementIsPresent(txt_Warning));
    }
}
