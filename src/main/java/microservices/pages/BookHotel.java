package microservices.pages;

import org.openqa.selenium.By;

public class BookHotel {
    public static By txt_NotBookYet = By.xpath("//p[contains(text(),'Bạn chưa chọn phòng cho chuyến đi này')]");

    public static By btn_EditSearch = By.xpath("//button[contains(text(),'Chỉnh sửa tìm kiếm')]");
    public static By btn_Update = By.xpath("//span[contains(text(),'Cập nhật')]/..");

    public static By txt_NameHotel = By.xpath("//ul/li[1]//p[@class='roomItem__title']");
    public static By btn_ChooseHotel = By.xpath("//ul/li[1]//div[@class='roomItem__row'][1]//span[contains(text(),'Chọn phòng')]/..");
    public static By btn_ChooseHotel2 = By.xpath("//ul/li[2]//div[@class='roomItem__row'][1]//span[contains(text(),'Chọn phòng')]/..");
    public static By opt_Book = By.xpath("//p[normalize-space()='1 phòng']/..");

    public static By btn_ChooseRoomNotBed = By.xpath("//div[@class='roomItem__info'][not(div)]/../..//span[contains(text(),'Chọn phòng')]/..");
    public static By txt_NameRoomNoBed = By.xpath("//div[@class='roomItem__info'][not(div)]/p");

    public static By tag_BookedHotel = By.xpath("//p[@class='roomType__title']/..//ul//p[1]");
    public static By btn_Book = By.xpath("//button[contains(text(),'Đặt phòng')]");

    public static By error_msg_ExceedCapacity = By.xpath("//span[contains(text(),'Số người bạn chọn không phù hợp với sức chứa của phòng')]");
    public static By error_msg_RoomNoBed = By.xpath("//span[contains(text(),'Phòng bạn chọn chưa có loại giường')]");
    public static By error_msg_InvalidNumberRoom = By.xpath("//span[contains(text(),'Số phòng không được vượt quá số người')]");
}
