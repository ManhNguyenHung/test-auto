package microservices.pages;

import org.openqa.selenium.By;
//Khai báo xpath của trang login
public class Login {
    public static By inp_email = By.xpath("//input[@placeholder='Email']");
    public static By inp_password = By.xpath("//input[@placeholder='Mật khẩu']");
    public static By btn_Login = By.xpath("//span[normalize-space()='Đăng nhập']/..");
    public static By error_msg = By.xpath("//div[contains(text(),'Email hoặc mật khẩu không đúng')]") ;
    public static By error_msg_nodata = By.xpath("//div[contains(text(),'Vui lòng điền thông tin')]");

}
