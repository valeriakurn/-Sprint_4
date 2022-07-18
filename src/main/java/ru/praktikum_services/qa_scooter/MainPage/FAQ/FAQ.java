package ru.praktikum_services.qa_scooter.MainPage.FAQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum_services.qa_scooter.MainPage.MainPage;
import java.time.Duration;

public class FAQ extends MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By FAQ_HEADER = By.className("Home_SubHeader__zwi_E");
    private final By ACCEPT_COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    public FAQ(WebDriver driver) {
        super(driver);
    }

    public FAQ open() {
        DRIVER.get(MAIN_PAGE_URL);
        return this;
    }

    public FAQ clickOnAcceptCookieButton() {
        DRIVER.findElement(ACCEPT_COOKIE_BUTTON).click();
        return this;
    }

    public FAQ waitUntilFAQIsVisible() {
        new WebDriverWait(DRIVER, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(FAQ_HEADER));
        return this;
    }

    public FAQ scrollToFAQ() {
        ((JavascriptExecutor) DRIVER).executeScript("arguments[0].scrollIntoView();", DRIVER.findElement(FAQ_HEADER));
        return this;
    }

    private byte getQuestionNumberByText(String question) {
        byte questionNumber = 0;
        switch (question) {
            case ("Сколько это стоит? И как оплатить?"):
                questionNumber = 0;
                break;
            case ("Хочу сразу несколько самокатов! Так можно?"):
                questionNumber = 1;
                break;
            case ("Как рассчитывается время аренды?"):
                questionNumber = 2;
                break;
            case ("Можно ли заказать самокат прямо на сегодня?"):
                questionNumber = 3;
                break;
            case ("Можно ли продлить заказ или вернуть самокат раньше?"):
                questionNumber = 4;
                break;
            case ("Вы привозите зарядку вместе с самокатом?"):
                questionNumber = 5;
                break;
            case ("Можно ли отменить заказ?"):
                questionNumber = 6;
                break;
            case ("Я жизу за МКАДом, привезёте?"):
                questionNumber = 7;
                break;
        }
        return questionNumber;
    }

    public By getQuestionLocator(byte questionNumber) {
        return By.xpath(".//div[@id='accordion__heading-" + questionNumber + "']");
    }

    public FAQ clickOnQuestion(String question) {
        DRIVER.findElement(getQuestionLocator(getQuestionNumberByText(question))).click();
        return this;
    }

    public By getAnswerLocator(byte questionNumber) {
        return By.xpath(".//div[@id='accordion__panel-" + questionNumber + "']");
    }

    public FAQ waitUntilAnswerIsVisible(String question) {
        new WebDriverWait(DRIVER, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(getAnswerLocator(getQuestionNumberByText(question))));
        return this;
    }

    public String getAnswer(String question) {
        return DRIVER.findElement(getAnswerLocator(getQuestionNumberByText(question))).getText();
    }

}
