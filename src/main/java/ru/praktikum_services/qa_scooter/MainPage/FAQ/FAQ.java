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
    private final By FAQHeader = By.className("Home_SubHeader__zwi_E");
    private final By AcceptCookieButton = By.className("App_CookieButton__3cvqF");

    public FAQ(WebDriver driver) {
        super(driver);
    }

    public FAQ open() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public FAQ clickOnAcceptCookieButton() {
        driver.findElement(AcceptCookieButton).click();
        return this;
    }

    public FAQ waitUntilFAQIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(FAQHeader));
        return this;
    }

    public FAQ scrollToFAQ() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(FAQHeader));
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
        driver.findElement(getQuestionLocator(getQuestionNumberByText(question))).click();
        return this;
    }

    public By getAnswerLocator(byte questionNumber) {
        return By.xpath(".//div[@id='accordion__panel-" + questionNumber + "']");
    }

    public FAQ waitUntilAnswerIsVisible(String question) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(getAnswerLocator(getQuestionNumberByText(question))));
        return this;
    }

    public String getAnswer(String question) {
        return driver.findElement(getAnswerLocator(getQuestionNumberByText(question))).getText();
    }

}
