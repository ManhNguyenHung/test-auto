package Report;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {
    public AllureManager() {}

    @Attachment(value = "screenshot attachment", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        try {
            return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return new byte[0];
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
