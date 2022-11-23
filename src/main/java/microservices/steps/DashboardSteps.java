package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.Dashboard.*;

public class DashboardSteps extends WebUI {
    @Step("Verify login successfully")
    public void verifyLoginSuccessfully(){
        waitForElementIsPresence(menu,10);
        Assert.assertTrue(checkElementIsDisplayed(menu));
    }
    @Step("Redirect to Member Page")
    public void clickMember(){
        clickElement(btn_member);
    }

    @Step("Redirect to Book Hotel page")
    public void clickBookHotel() {
        clickElement(btn_Hotels);
    }

    @Step("Redirect to Flight page")
    public void clickBookFlight() {
        clickElement(btn_Flight);
    }

    @Step("Log out")
    public void logOut() {
        clickElement(btn_Profile);
        clickElement(btn_LogOut);
    }

}
