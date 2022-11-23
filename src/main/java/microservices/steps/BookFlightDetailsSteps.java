package microservices.steps;

import Utils.CaptureUtils;
import Utils.WebUI;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.BookFlightDetails.*;

public class BookFlightDetailsSteps extends WebUI {

    @Step("verify redirect to book flight detail page")
    public void verifyRedirectToBookFlightDetail() {
        waitForElementIsPresence(txt_FlightInformation, 5);
        Assert.assertTrue(elementIsPresent(txt_FlightInformation));
    }

    @Step("Click continue button")
    public void clickContinue() {
        clickElement(btn_Continue);
    }

    @Step("Verify message error")
    public void verifyInvalidPassenger() {
        sleep(500);
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Invalid Passenger");
        Assert.assertTrue(elementIsPresent(error_msg_InvalidPassenger));
    }
}
