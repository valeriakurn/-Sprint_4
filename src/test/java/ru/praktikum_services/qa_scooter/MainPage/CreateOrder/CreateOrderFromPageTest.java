package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.junit.Test;
import ru.praktikum_services.qa_scooter.MainPage.MainPageFirefoxSettings;

import static org.junit.Assert.assertTrue;

public class CreateOrderFromPageTest extends MainPageFirefoxSettings {

    @Test
    public void createOrderFromPage() {
        boolean isOrderCreatedModalWindowDisplayed = new ContactInfo(driver)
                .open()
                .clickOnAcceptCookieButton()
                .clickOnCreateOrderButtonPage()
                .enterName("Савва")
                .enterSurname("Морозов")
                .enterAddress("Тверская, 16")
                .openMetroStationList()
                .enterMetroStation("Тверская")
                .selectChosenMetroStation()
                .enterPhone("+70000000000")
                .clickOnNextButton()
                .clickOnDatePicker()
                .setDate("21.09.2022")
                .saveDate()
                .clickOnTimePicker()
                .selectTime("сутки")
                .setColorGrey()
                .enterComment("Хочу самый красивый самокат")
                .clickOnCreateOrderButton()
                .clickOnConfirmOrderButton()
                .isOrderCreatedModalWindowDisplayed();

        assertTrue("Order created modal is not displayed", isOrderCreatedModalWindowDisplayed);
    }

}
