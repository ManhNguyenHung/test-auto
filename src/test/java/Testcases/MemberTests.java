package Testcases;

import Bases.BaseTest;
import Utils.ExcelConfig;
import Utils.PropertiesFile;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import microservices.steps.DashboardSteps;
import microservices.steps.LoginPageSteps;
import microservices.steps.MemberSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MemberTests extends BaseTest {
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    DashboardSteps dashboardSteps = new DashboardSteps();
    MemberSteps memberStep = new MemberSteps();
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/data.xlsx");
    int sheetIndexTestCasesMember = 1;

    @BeforeMethod
    public void preTest() {
        String emailLogin = PropertiesFile.getPropValue("email");
        String password = PropertiesFile.getPropValue("password");
        loginPageSteps.loginWithCredentials(emailLogin, password);
        dashboardSteps.verifyLoginSuccessfully();
    }

    @DataProvider
    public Object[][] addMembers() {
        return excelConfig.data(sheetIndexTestCasesMember);
    }

    @Test(dataProvider = "addMembers", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void addNewMembers(String gender, String fullName, String city, String email,
                              String position, String phoneNumber, String role, String id) {
        dashboardSteps.clickMember();
        memberStep.ClickNewMember();
        memberStep.InformationNewMember(gender, fullName, city, email, position, phoneNumber, role, id);
        memberStep.verifyMessage();
        memberStep.searchById(id);
        memberStep.verifyAddNewMemberSuccessfully(id);
    }

    @Test(description = "add new member with empty all fields", priority = 1)
    public void addNewMemberEmptyAllFields() {
        dashboardSteps.clickMember();
        memberStep.ClickNewMember();
        memberStep.clickAddButton();
        memberStep.verifyMessage();
    }
}
