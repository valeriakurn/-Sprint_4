package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.MainPage.MainPage;

public class RentInfo extends MainPage {
    private final By HEADER = By.className("Order_Header__BZXOb");
    private final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By TIME_INPUT = By.className("Dropdown-placeholder");
    private final By COLOR_BLACK_CHECKBOX = By.id("black");
    private final By COLOR_GREY_CHECKBOX = By.id("grey");
    private final By COMMENT_INPUT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By CREATE_ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    private final By CONFIRM_ORDER_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[2]");
    private final By ORDER_CREATED_MODAL_WINDOW = By.className("Order_Text__2broi");

    public RentInfo(WebDriver driver) {
        super(driver);
    }

    public RentInfo clickOnDatePicker() {
        DRIVER.findElement(DATE_INPUT).click();
        return this;
    }

    public RentInfo setDate(String date) {
        DRIVER.findElement(DATE_INPUT).sendKeys(date);
        return this;
    }

    public RentInfo saveDate() {
        DRIVER.findElement(HEADER).click();
        return this;
    }

    public RentInfo clickOnTimePicker() {
        DRIVER.findElement(TIME_INPUT).click();
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
        DRIVER.findElement(getTimePeriodLocator(getTimePeriodByText(timePeriod))).click();
        return this;
    }

    public RentInfo setColorBlack() {
        DRIVER.findElement(COLOR_BLACK_CHECKBOX).click();
        return this;
    }

    public RentInfo setColorGrey() {
        DRIVER.findElement(COLOR_GREY_CHECKBOX).click();
        return this;
    }

    public RentInfo enterComment(String comment) {
        DRIVER.findElement(COMMENT_INPUT).sendKeys(comment);
        return this;
    }

    public RentInfo clickOnCreateOrderButton() {
        DRIVER.findElement(CREATE_ORDER_BUTTON).click();
        return this;
    }

    public RentInfo clickOnConfirmOrderButton() {
        DRIVER.findElement(CONFIRM_ORDER_BUTTON).click();
        return this;
    }

    public boolean isOrderCreatedModalWindowDisplayed() {
        return DRIVER.findElement(ORDER_CREATED_MODAL_WINDOW).isDisplayed();
    }

}
