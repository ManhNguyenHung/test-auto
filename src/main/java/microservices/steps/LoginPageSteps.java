package microservices.steps;

import Utils.WebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static microservices.pages.Login.*;

//Khai báo thao tác trên màn hình Login
public class LoginPageSteps extends WebUI {

    @Step("Login with email {0} and password {1}")
    public void loginWithCredentials(String email, String password) {
        sendKeys(inp_email, email);
        sendKeys(inp_password, password);
        clickElement(btn_Login);
    }

    @Step("Logout successfully")
    public void logoutSuccessfully() {
        Assert.assertTrue(elementIsPresent(inp_email));
    }
}

