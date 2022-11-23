package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.HotelLists.btn_ViewHotel;

public class HotelListsSteps extends WebUI {

    @Step("verify redirect to hotel list page")
    public void verifyRedirectToHotelList() {
        waitForElementIsPresence(btn_ViewHotel, 5);
        Assert.assertTrue(elementIsPresent(btn_ViewHotel));
    }

    @Step("click view hotel")
    public void clickViewHotel() {
        clickElement(btn_ViewHotel);
    }
}
