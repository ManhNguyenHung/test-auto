package microservices.pages;

import org.openqa.selenium.By;

public class FlightLists {
    public static By radiobtn_FlightEarliest = By.xpath("//span[contains(text(),'Cất cánh sớm nhất')]/..//input");
    public static By txt_FlightAddress = By.xpath("//div[@id='SectionListFlight']/div[1]//div[@class='flightTrip']/div[1]/p[2]");
    public static By btn_ChooseFlight = By.xpath("//div[@id='SectionListFlight']/div[1]//button[contains(text(),'Chọn')]");

    public static By btn_Book = By.xpath("//button[contains(text(),'Đặt chỗ')]");
    public static By txt_Warning = By.xpath("//span[contains(text(),'Chuyến đi và chuyến về phải chênh lệch ít nhất 4 tiếng')]");

}
