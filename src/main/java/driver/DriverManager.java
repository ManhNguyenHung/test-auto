package driver;

import org.openqa.selenium.WebDriver;
//khởi tạo driver, chi gọi 1 lần
public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }
}
