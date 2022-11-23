package Utils;


import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebUI {
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;
    Robot robot;
    WebDriver driver = DriverManager.getDriver();

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void clickElementByJs(By by) {
        sleep(2000);
        js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        js.executeScript("arguments[0].click()", element);
    }

    public void sendKeys(By by, String value) {
        clickElement(by);
        driver.findElement(by).sendKeys(value);
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public void uploadFile(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public void selectElementByIndex(By by, int index) {
        Select slc = new Select(driver.findElement(by));
        slc.selectByIndex(index);
    }

    public List<WebElement> get_List_Element(By by) {
        return driver.findElements(by);
    }

    public void selectElementByValue(By by, String value) {
        Select slc = new Select(driver.findElement(by));
        slc.selectByValue(value);
    }

    public String getValueOfElement(By by) {
        return driver.findElement(by).getAttribute("value");
    }

    public void selectElementByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public boolean elementIsPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForElementToBeClickable(By by, int time) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element to be clickable: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    public void waitForElementIsPresence(By by, int time) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element visibility: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    public void waitForElementIsInvisible(By by, int time) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element invisibility: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    public boolean checkElementIsEnable(By by) {
        return driver.findElement(by).isEnabled();
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressEnter(By by) {
        WebElement element = driver.findElement(by);
        element.sendKeys(Keys.ENTER);
    }

    public void pressTab(By by) {
        WebElement element = driver.findElement(by);
        element.sendKeys(Keys.TAB);
    }

    public boolean checkElementIsDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public By replaceValueInXpath(String oldXpath, String oldVal, String newVal) {
        return By.xpath(oldXpath.replace(oldVal, newVal));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clearText(By by) {
        clickElement(by);
        WebElement element = driver.findElement(by);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public void switchToLastTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        DriverManager.getDriver().switchTo().window(driver.getWindowHandles().toArray()[windowHandles.size() - 1].toString());
    }

    public void uploadFileForm(By by, String filePath) {
        action = new Actions(driver);

        action.moveToElement(driver .findElement(by)).click().perform();
        sleep(3000);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        assert robot != null;
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
