package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.MainPage.MainPage;

public class RentInfo extends MainPage {
    private final By Header = By.className("Order_Header__BZXOb");
    private final By DateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By TimeInput = By.className("Dropdown-placeholder");
    private final By ColorBlackCheckbox = By.id("black");
    private final By ColorGreyCheckbox = By.id("grey");
    private final By CommentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By CreateOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    private final By ConfirmOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[2]");
    private final By OrderCreatedModalWindow = By.className("Order_Text__2broi");

    public RentInfo(WebDriver driver) {
        super(driver);
    }

    public RentInfo clickOnDatePicker() {
        driver.findElement(DateInput).click();
        return this;
    }

    public RentInfo setDate(String date) {
        driver.findElement(DateInput).sendKeys(date);
        return this;
    }

    public RentInfo saveDate() {
        driver.findElement(Header).click();
        return this;
    }

    public RentInfo clickOnTimePicker() {
        driver.findElement(TimeInput).click();
        return this;
    }

    private byte getTimePeriodByText(String timePeriod) {
        byte timePeriodNumber = 0;
        switch (timePeriod) {
            case ("сутки"):
                timePeriodNumber = 1;
                break;
            case ("двое суток"):
                timePeriodNumber = 2;
                break;
            case ("трое суток"):
                timePeriodNumber = 3;
                break;
            case ("четверо суток"):
                timePeriodNumber = 4;
                break;
            case ("пятеро суток"):
                timePeriodNumber = 5;
                break;
            case ("шестеро суток"):
                timePeriodNumber = 6;
                break;
            case ("семеро суток"):
                timePeriodNumber = 7;
                break;
        }
        return timePeriodNumber;
    }

    public By getTimePeriodLocator(byte timePeriodNumber) {
        return By.xpath(".//div[" + timePeriodNumber + "][@class='Dropdown-option']");
    }

    public RentInfo selectTime(String timePeriod) {
        driver.findElement(getTimePeriodLocator(getTimePeriodByText(timePeriod))).click();
        return this;
    }

    public RentInfo setColorBlack() {
        driver.findElement(ColorBlackCheckbox).click();
        return this;
    }

    public RentInfo setColorGrey() {
        driver.findElement(ColorGreyCheckbox).click();
        return this;
    }

    public RentInfo enterComment(String comment) {
        driver.findElement(CommentInput).sendKeys(comment);
        return this;
    }

    public RentInfo clickOnCreateOrderButton() {
        driver.findElement(CreateOrderButton).click();
        return this;
    }

    public RentInfo clickOnConfirmOrderButton() {
        driver.findElement(ConfirmOrderButton).click();
        return this;
    }

    public boolean isOrderCreatedModalWindowDisplayed() {
        return driver.findElement(OrderCreatedModalWindow).isDisplayed();
    }

}
