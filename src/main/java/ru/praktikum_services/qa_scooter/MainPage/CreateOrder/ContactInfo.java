package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.MainPage.MainPage;

public class ContactInfo extends MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By ACCEPT_COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");
    private final By CREATE_ORDER_BUTTON_HEADER = By.className("Button_Button__ra12g");
    private final By CREATE_ORDER_BUTTON_PAGE = By.className("Home_FinishButton__1_cWm");
    private final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    private final By SURNAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By METRO_STATION_INPUT = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By ENTERED_METRO_STATION = By.className("Order_Circle__3uWFr");
    private final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public ContactInfo(WebDriver driver) {
        super(driver);
    }

    public ContactInfo open() {
        DRIVER.get(MAIN_PAGE_URL);
        return this;
    }

    public ContactInfo clickOnAcceptCookieButton() {
        DRIVER.findElement(ACCEPT_COOKIE_BUTTON).click();
        return this;
    }

    public ContactInfo clickOnCreateOrderButtonHeader() {
        DRIVER.findElement(CREATE_ORDER_BUTTON_HEADER).click();
        return this;
    }

    public ContactInfo clickOnCreateOrderButtonPage() {
        DRIVER.findElement(CREATE_ORDER_BUTTON_PAGE).click();
        return this;
    }

    public ContactInfo enterName(String name) {
        DRIVER.findElement(NAME_INPUT).sendKeys(name);
        return this;
    }

    public ContactInfo enterSurname(String surname) {
        DRIVER.findElement(SURNAME_INPUT).sendKeys(surname);
        return this;
    }

    public ContactInfo enterAddress(String address) {
        DRIVER.findElement(ADDRESS_INPUT).sendKeys(address);
        return this;
    }

    public ContactInfo openMetroStationList() {
        DRIVER.findElement(METRO_STATION_INPUT).click();
        return this;
    }

    public ContactInfo enterMetroStation(String metroStation) {
        DRIVER.findElement(METRO_STATION_INPUT).sendKeys(metroStation);
        return this;
    }

    public ContactInfo selectChosenMetroStation() {
        DRIVER.findElement(ENTERED_METRO_STATION).click();
        return this;
    }

    public ContactInfo enterPhone(String phone) {
        DRIVER.findElement(PHONE_INPUT).sendKeys(phone);
        return this;
    }

    public RentInfo clickOnNextButton() {
        DRIVER.findElement(NEXT_BUTTON).click();
        return new RentInfo(DRIVER);
    }

}
