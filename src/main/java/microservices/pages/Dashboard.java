package microservices.pages;

import org.openqa.selenium.By;

public class Dashboard {
    public static By menu = By.xpath("//nav[@class='sidebar__nav']");
    public static By btn_member = By.xpath("//span[contains(text(),'Thành viên')]");
    public static By btn_Hotels = By.xpath("//span[contains(text(),'Đặt khách sạn')]/..");
    public static By btn_Flight = By.xpath("//span[contains(text(),'Vé máy bay')]/..");

    public static By btn_Profile = By.xpath("//i[@class='accountDropdown__name']/..");
    public static By btn_LogOut = By.xpath("//span[contains(text(),'Đăng xuất')]/../..");
}
