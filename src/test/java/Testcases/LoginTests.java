package Testcases;

import Bases.BaseTest;
import Utils.ExcelConfig;
import microservices.steps.DashboardSteps;
import microservices.steps.LoginPageSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//Viết test case cho màn hình login
public class LoginTests extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/data.xlsx");
    int sheetIndexTestCasesLogin = 0;

    @DataProvider
    public Object[][] dataLogin() {
        return excelConfig.data(sheetIndexTestCasesLogin);
    }

    @Test(dataProvider = "dataLogin")
    public void LoginPass(String email, String password) {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.loginWithCredentials(email, password);
        DashboardSteps dashboardSteps = new DashboardSteps();
        dashboardSteps.verifyLoginSuccessfully();
    }

}
