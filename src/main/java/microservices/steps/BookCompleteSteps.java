package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.BookComplete.*;

public class BookCompleteSteps extends WebUI {

    @Step("Payment for book hotel successfully")
    public void verifyPaymentForHotelSuccessfully() {
        waitForElementIsPresence(txt_BookHotelSuccessfully, 10);
        Assert.assertTrue(elementIsPresent(txt_BookHotelSuccessfully));
    }

    @Step("Payment for book flight successfully")
    public void verifyPaymentForFlightSuccessfully() {
        waitForElementIsPresence(txt_BookFlightSuccessfully, 10);
        Assert.assertTrue(elementIsPresent(txt_BookFlightSuccessfully));
    }
}
