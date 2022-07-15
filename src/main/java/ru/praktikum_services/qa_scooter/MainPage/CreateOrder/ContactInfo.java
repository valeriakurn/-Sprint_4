package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.MainPage.MainPage;

public class ContactInfo extends MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By AcceptCookieButton = By.className("App_CookieButton__3cvqF");
    private final By CreateOrderButtonHeader = By.className("Button_Button__ra12g");
    private final By CreateOrderButtonPage = By.className("Home_FinishButton__1_cWm");
    private final By NameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By SurnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By AddressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By MetroStationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By EnteredMetroStation = By.className("Order_Circle__3uWFr");
    private final By PhoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By NextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public ContactInfo(WebDriver driver) {
        super(driver);
    }

    public ContactInfo open() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public ContactInfo clickOnAcceptCookieButton() {
        driver.findElement(AcceptCookieButton).click();
        return this;
    }

    public ContactInfo clickOnCreateOrderButtonHeader() {
        driver.findElement(CreateOrderButtonHeader).click();
        return this;
    }

    public ContactInfo clickOnCreateOrderButtonPage() {
        driver.findElement(CreateOrderButtonPage).click();
        return this;
    }

    public ContactInfo enterName(String name) {
        driver.findElement(NameInput).sendKeys(name);
        return this;
    }

    public ContactInfo enterSurname(String surname) {
        driver.findElement(SurnameInput).sendKeys(surname);
        return this;
    }

    public ContactInfo enterAddress(String address) {
        driver.findElement(AddressInput).sendKeys(address);
        return this;
    }

    public ContactInfo openMetroStationList() {
        driver.findElement(MetroStationInput).click();
        return this;
    }

    public ContactInfo enterMetroStation(String metroStation) {
        driver.findElement(MetroStationInput).sendKeys(metroStation);
        return this;
    }

    public ContactInfo selectChosenMetroStation() {
        driver.findElement(EnteredMetroStation).click();
        return this;
    }

    public ContactInfo enterPhone(String phone) {
        driver.findElement(PhoneInput).sendKeys(phone);
        return this;
    }

    public RentInfo clickOnNextButton() {
        driver.findElement(NextButton).click();
        return new RentInfo(driver);
    }

}
