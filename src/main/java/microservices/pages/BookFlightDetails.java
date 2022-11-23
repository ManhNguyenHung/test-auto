package microservices.pages;

import org.openqa.selenium.By;

public class BookFlightDetails {
    public static By txt_FlightInformation = By.xpath("//h3[contains(text(),'Thông tin chuyến bay')]");
    public static By btn_Continue = By.xpath("//span[contains(text(),'Tiếp tục')]/..");

    public static By error_msg_InvalidPassenger = By.xpath("//span[contains(text(),'Booker with member or approver role must be in list of passenger')]");
}
