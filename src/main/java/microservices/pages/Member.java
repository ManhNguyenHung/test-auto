package microservices.pages;

import org.openqa.selenium.By;

public class Member {

    //Thêm nhân viên

    public static By btn_newMember = By.xpath("//span[contains(text(),'+ Thêm nhân viên')]");

    public static By form_addNewMember = By.xpath("//div[@class='ant-drawer-body']");
    //Danh xưng
    public static String genderXpath = "//span[normalize-space()='genderData']/..";
    //Họ và tên
    public static By inp_fullName = By.xpath("//input[@placeholder='Nhập họ và tên thành viên']");
    //Bộ phận
    public static By btn_department = By.xpath("//label[normalize-space()='Bộ phận']/../../div[2]");
    public static String cityXpath = "//span[contains(text(),'cityData')]";
    //Email
    public static By inp_email = By.xpath("//input[@placeholder='Nhập địa chỉ email']");
    //Chức vụ
    public static By btn_choosePosition = By.xpath("//label[contains(text(),'Chức vụ')]/../..//span[2]");
    public static String positionXpath = "//div[contains(text(),'positionData')]";
    //Số điện thoại
    public static By inp_phoneNumber = By.xpath("//input[@placeholder='Nhập số điện thoại']");
    //Vai trò
    public static By btn_chooseRole = By.xpath("//label[normalize-space()='Vai trò']/../../div[2]");
    public static String roleXpath = "//div[contains(text(),'roleData')]";
    //Mã nhân viên
    public static By inp_id = By.xpath("//input[@class='ant-input']");
    //Ngôn ngữ mặc định
    public static By btn_defaultLanguage = By.xpath("//span[normalize-space()='Tiếng Việt']/..");
    //Thêm
    public static By btn_add = By.xpath("//span[normalize-space()='Thêm']/..");

    //Form create existed corporate
    public static By popup_ExistedCorporate = By.xpath("//span[normalize-space()='email cho corporate đã tồn tại']");
    //Form create successfully
    public static By popup_AddSuccessfully = By.xpath("//span[contains(text(),'Thêm thành viên thành công')]");
    //Search
    public static By icon_search = By.xpath("//span[normalize-space()='Mã nhân viên']/../span[2]");
    public static By inp_search = By.xpath("//input[@placeholder='Tìm kiếm theo mã nhân viên ...']");
    public static By btn_search = By.xpath("//span[contains(text(),'Tìm kiếm')]");
    public static By txt_id = By.xpath("//tbody/tr[1]/td[1]");

}
