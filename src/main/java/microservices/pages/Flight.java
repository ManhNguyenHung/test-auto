package microservices.pages;

import org.openqa.selenium.By;

public class Flight {
    public static By txt_BookFlight = By.xpath("//h2[contains(text(),'Đặt khách sạn / máy bay')]");
    public static By radiobtn_TwoWay = By.xpath("//input[@value='TWO_WAY']");
    public static By inp_From = By.xpath("//input[@placeholder='Chọn điểm đi']");
    public static By opt_From = By.xpath("//ul[@class='listPlace']/li");
    public static By inp_To = By.xpath("//input[@placeholder='Chọn điểm đến']");
    public static By opt_To = By.xpath("//div[@class='suggestPlace suggestPlace_flight open']//li[contains(@class,'listPlace__item')]");
    public static By inp_FromDate = By.xpath("//input[@placeholder='Ngày đi']");
    public static By inp_ToDate = By.xpath("//input[@placeholder='Ngày về']");

    public static By inp_BusinessTrip = By.xpath("//label[contains(text(),'Thêm người đi công tác')]/..//input");
    public static By opt_BusinessTrip = By.xpath("//span[normalize-space()='admin_corp@yopmail.com']/..");

    public static By btn_Search = By.xpath("//button[text()='Tìm kiếm']");
}
