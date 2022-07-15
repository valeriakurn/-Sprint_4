package ru.praktikum_services.qa_scooter.MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MainPageFirefoxSettings {

    protected WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager
                .firefoxdriver()
                .setup();

        driver = new FirefoxDriver();
        driver
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

