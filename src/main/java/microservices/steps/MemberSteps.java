package microservices.steps;

import Utils.CaptureUtils;
import Utils.Log4j;
import Utils.WebUI;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static microservices.pages.Member.*;

public class MemberSteps extends WebUI {
    @Step("open form add new member")
    public void ClickNewMember() {
        waitForElementIsPresence(btn_newMember, 5);
        clickElement(btn_newMember);
        waitForElementIsPresence(form_addNewMember, 5);
    }

    @Step("fill in information")
    public void InformationNewMember(String gender, String fullName, String city, String email, String position, String phoneNumber, String role, String id) {
        //Danh xưng
        By radioBTN_checkbox = replaceValueInXpath(genderXpath, "genderData", gender);
        clickElement(radioBTN_checkbox);

        //Họ và tên
        sendKeys(inp_fullName, fullName);

        //Bộ phận
        clickElement(btn_department);

        //City
        By btn_city = replaceValueInXpath(cityXpath, "cityData", city);
        clickElement(btn_city);

        //Email
        sendKeys(inp_email, email);

        //Chức vụ
        clickElement(btn_choosePosition);
        By btn_position = replaceValueInXpath(positionXpath, "positionData", position);
        clickElement(btn_position);

        //Số điện thoại
        sendKeys(inp_phoneNumber, phoneNumber);

        //Vai trò
        clickElement(btn_chooseRole);
        By btn_role = replaceValueInXpath(roleXpath, "roleData", role);
        clickElement(btn_role);

        //Mã nhân viên
        sendKeys(inp_id, id);

        //Ngôn ngữ mặc định
        clickElement(btn_defaultLanguage);

        clickAddButton();
    }

    @Step("Click button add member")
    public void clickAddButton() {
        //Thêm
        clickElement(btn_add);
    }

    @Step("Verify message")
    public void verifyMessage() {
//        if (elementIsPresent(popup_ExistedCorporate)){
//            CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Existed Corporate");
//        } else {
//            CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Error data");
//        }
        sleep(1000);
        CaptureUtils.captureAndAttachToReport(DriverManager.getDriver(), "Error");
        Assert.assertTrue(elementIsPresent(popup_AddSuccessfully));
        sleep(3000);
    }

    @Step("search member by id: {0}")
    public void searchById(String id) {
        refreshPage();
        clickElementByJs(icon_search);
        waitForElementIsPresence(inp_search, 5);
        sendKeys(inp_search, id);
        clickElement(btn_search);
        sleep(5000);
    }

    @Step("verify add new member with id: {0} successfully")
    public void verifyAddNewMemberSuccessfully(String id) {
        String idNewMember = getText(txt_id);
        Log4j.info(idNewMember);
        Assert.assertEquals(idNewMember, id);
    }
}
