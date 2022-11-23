package microservices.steps;

import Utils.Log4j;
import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.BookHotelDetails.*;

public class BookHotelDetailsSteps extends WebUI {
    String fileName = "congvan.docx";
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + fileName;

    @Step("verify redirect to book detail page")
    public void verifyRedirectToBookDetail() {
        waitForElementIsPresence(txt_InformationUser, 5);
        Assert.assertTrue(elementIsPresent(txt_InformationUser));
    }

    @Step("attach file")
    public void attachFile() {
        Log4j.info(filePath);
        sleep(5000);
        uploadFileForm(link_ChooseFile, filePath);
    }

    @Step("verify attach successfully")
    public void verifyAttachSuccessfully() {
        waitForElementIsPresence(attachment_FileName, 5);
        String getNameFileAttach = getText(attachment_FileName);
        Assert.assertTrue(getNameFileAttach.contains(fileName));
    }

    @Step("add note")
    public void addNote() {
        clickElement(link_LocalNote);
        sendKeys(inp_LocalNote,"day la ghi chu noi bo");
        clickElement(link_VntripNote);
        sendKeys(inp_VntripNote, "day la ghi chu vntrip");
        clickElement(btn_Continue);
    }

}
