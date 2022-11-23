package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.Payment.*;

public class PaymentSteps extends WebUI {

    @Step("verify redirect to payment page")
    public void verifyRedirectToPayment() {
        waitForElementIsPresence(txt_PaymentMethod, 5);
        Assert.assertTrue(elementIsPresent(txt_PaymentMethod));
    }

    @Step
    public void checkOverLimit() {
        waitForElementToBeClickable(radiobtn_PaymentDebt, 5);
        if(elementIsPresent(txt_OverLimit)) {
            sleep(3000);
            clickElement(btn_Continue);
            waitForElementIsPresence(form_OverLimit, 3);
            sendKeys(inp_OverLimit, "vuot han muc");
            clickElement(btn_ContinueOL);
        } else {
            clickElement(btn_Continue);
        }
        waitForElementIsPresence(txt_PayDebt, 3);
        clickElement(btn_Pay);
    }

    @Step
    public void waitForKeepSeatSuccessfully() {
        waitForElementIsInvisible(popup_KeepSeat, 20);
        Assert.assertFalse(elementIsPresent(popup_KeepSeat));
        Assert.assertTrue(elementIsPresent(txt_KeepSeatSuccessfully));
        clickElement(btn_ChoosePayment);
    }

    @Step
    public void conductPayment() {
        waitForElementIsPresence(txt_ReceiveCheck, 10);
        Assert.assertTrue(elementIsPresent(txt_ReceiveCheck));
    }
}
