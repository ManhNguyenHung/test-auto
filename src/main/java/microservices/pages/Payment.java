package microservices.pages;

import org.openqa.selenium.By;

public class Payment {
    public static By txt_PaymentMethod = By.xpath("//h2[contains(text(),'Chọn hình thức thanh toán')]");
    public static By txt_OverLimit = By.xpath("//span[contains(text(),'Vượt hạn mức')]");
    public static By btn_Continue = By.xpath("//button[@class='ant-btn ant-btn-primary btn']");
    public static By radiobtn_PaymentDebt = By.xpath("//p[contains(text(),'Thanh toán công nợ')]/../..");

    public static By form_OverLimit = By.xpath("//div[contains(text(),'Thanh toán vượt hạn mức')]");
    public static By inp_OverLimit = By.xpath("//div[contains(text(),'Thanh toán vượt hạn mức')]/../..//textarea");
    public static By btn_ContinueOL = By.xpath("//button[@class='ant-btn ant-btn-primary']//span[contains(text(),'Tiếp tục')]");


    public static By txt_PayDebt = By.xpath("//div[contains(text(),'Xác nhận thanh toán công nợ')]");
    public static By btn_Pay = By.xpath("//button[@type='button']//span[contains(text(),'Thanh toán')]");

    public static By popup_KeepSeat = By.xpath("//p[contains(text(),'Hệ thống đang tiến hành giữ chỗ')]/..");
    public static By txt_KeepSeatSuccessfully = By.xpath("//p[contains(text(),'Giữ chỗ thành công')]");
    public static By btn_ChoosePayment = By.xpath("//span[contains(text(),'Chọn hình thức thanh toán')]/..");
    public static By txt_ReceiveCheck = By.xpath("//h2[contains(text(),'Nơi ghi nhận xuất hóa đơn')]");
}
