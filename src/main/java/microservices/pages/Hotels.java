package microservices.pages;

import org.openqa.selenium.By;

public class Hotels {
    public static By txt_BookHotel = By.xpath("//h2[contains(text(),'Đặt khách sạn / máy bay')]");
    public static By inp_Location = By.xpath("//input[@placeholder='Thành phố, vùng, quận, khách sạn cụ thể']/..");
    public static String xpath_location = "//p[contains(text(),'location')]/../..";

    public static By inp_DateFrom = By.xpath("//input[@placeholder='Nhận phòng']");
    public static By inp_DateTo = By.xpath("//input[@placeholder='Trả phòng']");

    public static By inp_BusinessTraveller = By.xpath("//label[contains(text(),'Thêm người đi công tác')]/..//input");
    public static By opt_BusinessTraveller = By.xpath("//span[normalize-space()='admin_corp@yopmail.com']/..");

    public static By btn_ChooseAppointedHotel = By.xpath("//h2[contains(text(),'Các khách sạn công tác thường xuyên')]/..//ul[@class='listHotel']/li[1]//a[contains(text(),'Xem khách sạn')]");

    public static String list_BusinessTraveller = "//div[@class='boxMemberFrequency']/button[number]";
    public static By error_msg_NoBusinessTraveller = By.xpath("//label[contains(text(),'Thêm người đi công tác')]/../div/div[2]");
    //label[contains(text(),'Thêm người đi công tác')]/../div/div[2]
    //div[contains(text(),'Vui lòng chọn hành khách')]
    public static By error_msg_OverBusinessTraveller = By.xpath("//div[contains(text(),'Chỉ được chọn tối đa 6 thành viên')]");

    public static By btn_Search = By.xpath("//span[text()='Tìm kiếm']/..");
}
