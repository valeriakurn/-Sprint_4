package ru.praktikum_services.qa_scooter.MainPage.FAQ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum_services.qa_scooter.MainPage.MainPageChromeSettings;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQTestWrongAnswers extends MainPageChromeSettings {
    private final String question;
    private final String expectedAnswer;

    public FAQTestWrongAnswers(String question, String expectedAnswer) {
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getFAQWrongData() {
        return new Object[][] {
                { "Сколько это стоит? И как оплатить?", "Сутки — 300 рублей. Оплата курьеру — наличными или картой."},
                { "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — два самоката. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 12 мая. Мы привозим самокат 12 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня."},
                { "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 9999."},
                { "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на десять суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет. Все же свои."},
                { "Я жизу за МКАДом, привезёте?", "Нет, не привезём."},
        };
    }

    @Test
    public void checkFAQ() {
        String actualAnswer = new FAQ(driver)
                .open()
                .clickOnAcceptCookieButton()
                .waitUntilFAQIsVisible()
                .scrollToFAQ()
                .clickOnQuestion(question)
                .waitUntilAnswerIsVisible(question)
                .getAnswer(question);

        assertEquals("Wrong answer was received", expectedAnswer, actualAnswer);
    }

}
