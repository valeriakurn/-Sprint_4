package ru.praktikum_services.qa_scooter.MainPage.CreateOrder;

import org.junit.Test;
import ru.praktikum_services.qa_scooter.MainPage.MainPageFirefoxSettings;
import static org.junit.Assert.assertTrue;

public class CreateOrderFromHeaderTest extends MainPageFirefoxSettings {

    @Test
    public void createOrderFromHeader() {
        boolean isOrderCreatedModalWindowDisplayed = new ContactInfo(driver)
                .open()
                .clickOnAcceptCookieButton()
                .clickOnCreateOrderButtonHeader()
                .enterName("Иван")
                .enterSurname("Крузенштерн")
                .enterAddress("Льва Толстого, 16")
                .openMetroStationList()
                .enterMetroStation("Войковская")
                .selectChosenMetroStation()
                .enterPhone("+79999999999")
                .clickOnNextButton()
                .clickOnDatePicker()
                .setDate("19.08.2022")
                .saveDate()
                .clickOnTimePicker()
                .selectTime("четверо суток")
                .setColorBlack()
                .enterComment("Требуется самокат с полным зарядом")
                .clickOnCreateOrderButton()
                .clickOnConfirmOrderButton()
                .isOrderCreatedModalWindowDisplayed();

        assertTrue("Order created modal is not displayed", isOrderCreatedModalWindowDisplayed);
    }

}
