package webPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {// наследуемся

    public LoginPage(WebDriver driver) {// создаем конструктор
        super(driver);
    }

    @FindBy(xpath = "//input[@type=\"text\"]")// поле username
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type=\"password\"]")// поле password
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class=\"mdc-button__label\"]")// кнопка зарегистрироваться
    private WebElement loginButton;

   @Step ("Авторизация пользователя")
    public MyPostsPage loginIn(String login, String password) throws InterruptedException {// на вход передаем логин и пароль
        // метод для регистрации( включает все действия)
        usernameField.click();
        usernameField.sendKeys(login);// вбиваем логин
        passwordField.click();
        passwordField.sendKeys(password);//вбиваем пароль
        loginButton.click();//кликаем
        Thread.sleep(3000);
        return new MyPostsPage(driver);
    }



    @Step("Проверяем что остались на той же странице(по url)")
    public void checkUrl(){
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

}

