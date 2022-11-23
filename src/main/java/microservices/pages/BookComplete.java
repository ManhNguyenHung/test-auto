package microservices.pages;

import org.openqa.selenium.By;

public class BookComplete {
    public static By txt_BookHotelSuccessfully = By.xpath("//p[contains(text(),'Đặt phòng thành công.')]");
    public static By txt_BookFlightSuccessfully = By.xpath("//p[contains(text(),'Đặt vé thành công.')]");
}
