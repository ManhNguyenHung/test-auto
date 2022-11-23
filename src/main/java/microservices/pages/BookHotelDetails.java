package microservices.pages;

import org.openqa.selenium.By;

public class BookHotelDetails {
    public static By txt_InformationUser = By.xpath("//h2[contains(text(),'Thông tin người đặt')]");

    public static By link_ChooseFile = By.xpath("//label[@class='attachments__upload']");
    public static By attachment_FileName = By.xpath("//div[@class='attachments__link']/a");

    public static By link_LocalNote = By.xpath("//span[contains(text(),'Ghi chú nội bộ')]");
    public static By inp_LocalNote = By.xpath("//span[contains(text(),'Ghi chú nội bộ')]/../..//textarea");
    public static By link_VntripNote = By.xpath("//span[contains(text(),'Ghi chú cho Vntrip')]");
    public static By inp_VntripNote = By.xpath("//span[contains(text(),'Ghi chú cho Vntrip')]/../..//textarea");

    public static By btn_Continue = By.xpath("//span[contains(text(),'Tiếp tục')]/..");
}
