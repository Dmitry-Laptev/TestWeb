package webPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
// базовый Page со всеми настройками, здась объявляем все необъодимое// все Page будут от него наследоваться
public class AbstractPage {// View- общее между Page и блоком
    public WebDriver driver;// объявляем драйвер
    public WebDriverWait webDriverWait;// объявляем WebDriverWait


    public AbstractPage(WebDriver driver) {// в конструктор передаем драйвер
        this.driver = driver;// инициализируем его
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));// инициализируем WebDriverWait
        PageFactory.initElements(driver, this);// передаем ему на вход драйвер и страницу


    }
}
