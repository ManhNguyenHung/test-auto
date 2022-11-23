package microservices.steps;

import Utils.CaptureUtils;
import Utils.WebUI;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.BookHotel.*;
import static microservices.pages.Hotels.*;
import static microservices.pages.Hotels.opt_BusinessTraveller;

public class BookHotelSteps extends WebUI {

    @Step("Switch to book hotel page")
    public void switchToBookHotel() {
        sleep(2000);
        switchToLastTab();
    }

    @Step("Verify when not choose any room yet")
    public void verifyNotChooseRoom() {
        waitForElementIsPresence(txt_NotBookYet, 5);
        Assert.assertTrue(elementIsPresent(txt_NotBookYet));
    }

    @Step("Book room")
    public void bookRoom() {
        clickElement(btn_ChooseHotel);
        clickElement(opt_Book);
        sleep(2000);
    }

    @Step("Verify booked room visible")
    public void verifyBookedRoom() {
        String hotelName = getText(txt_NameHotel);
        String nameHotelBooked = getText(tag_BookedHotel);
        Assert.assertTrue(elementIsPresent(tag_BookedHotel));
        Assert.assertTrue(nameHotelBooked.contains(hotelName));
    }

    @Step("Click book")
    public void clickBook() {
        clickElement(btn_Book);
    }

    @Step("Verify exceed capacity")
    public void verifyExceedCapacity() {
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Exceed Capacity");
        Assert.assertTrue(elementIsPresent(error_msg_ExceedCapacity));
    }

    @Step("Fill information")
    public void fillInformation() {
        clickElement(btn_EditSearch);
        clickElement(inp_BusinessTraveller);
        clickElement(opt_BusinessTraveller);
        clickElement(btn_Update);
    }

    @Step("Book room with no bed")
    public void bookRoomWithNoBed() {
        clickElement(btn_ChooseRoomNotBed);
        clickElement(opt_Book);
        sleep(2000);
    }

    @Step("Verify booked hotel no bed")
    public void verifyBookedRoomNoBed() {
        String hotelName = getText(txt_NameRoomNoBed);
        String nameHotelBooked = getText(tag_BookedHotel);
        Assert.assertTrue(elementIsPresent(tag_BookedHotel));
        Assert.assertTrue(nameHotelBooked.contains(hotelName));
    }

    @Step("Verify error hotel")
    public void verifyErrorHotel() {
        sleep(500);
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Error room has no bed");
        Assert.assertTrue(elementIsPresent(error_msg_RoomNoBed));
    }

    @Step("Book more room")
    public void bookMoreRoom() {
        bookRoom();
        clickElement(btn_ChooseHotel2);
        clickElement(opt_Book);
        sleep(2000);
    }

    @Step("Verify invalid number room")
    public void verifyInvalidNumberRoom() {
        sleep(500);
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Invalid Number Room");
        Assert.assertTrue(elementIsPresent(error_msg_InvalidNumberRoom));
    }
}
