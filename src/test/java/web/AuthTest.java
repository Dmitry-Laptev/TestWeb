package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webPages.LoginPage;
import webPages.MyPostsPage;
import webPages.PostPage;

public class AuthTest extends AbstractTest {

    LoginPage loginPage;
    MyPostsPage myPostsPage;
    PostPage postPage;
    protected String username = "GB202303ebb5d1012";
    protected String password = "c5f5e28ab5";

    @BeforeEach
    void init() {
    loginPage = new LoginPage(getWebDriver());
    myPostsPage = new MyPostsPage(getWebDriver());
    postPage = new PostPage(getWebDriver());
}
    @Test
    @Story("Положительный тест")
    public void test1() throws InterruptedException {
        loginPage.loginIn("Jdlkj5k5lk","f934jf9js09f");
        myPostsPage.checkChangeUrl();
    }

    @Test
    @Story("Логин 3 символа")
    @DisplayName("2: Авторизация пользователя с валидными Логином 3 символа и валидным Паролем ")
    public void test2() throws InterruptedException {
        loginPage.loginIn("465", "6f65dfg6g");
        myPostsPage.checkChangeUrl();
    }
    @Test
    @Story("Логин 20 символов")
    @DisplayName("3: Авторизация пользователя с валидными Логином 20 символов и валидным Паролем ")
    public void test3() throws InterruptedException {
        loginPage.loginIn("djl3ifj49fjs9eble84f","fusdafu9");
        myPostsPage.checkChangeUrl();
    }

    @Test
    @Story("Пустые поля")
    @DisplayName("4: Авторизация пользователя с пустыми Логином и пустым Паролем ")
    public void test4() throws InterruptedException {
        loginPage.loginIn("","");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }
    @Test
    @Story("Логин 2 символа")
    @DisplayName("6: Авторизация с невалидным логином 2 символа и валидным паролем")
    public void test6() throws InterruptedException {
        loginPage.loginIn("fd","9s8df9s8duf");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }
    @Test
    @Story("Логин 21 символ")
    @DisplayName("7: Авторизация с невалидным логином 21 символ и валидным паролем")
    public void test7() throws InterruptedException {
        loginPage.loginIn("djl3ifj49fjs9eble84f2","98dsf79sd87f");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }


    @Test
    @Story("НЕвалидная авторизация")
    @DisplayName("10: Авторизация с невалидным логином на анг+спецсимволы и валидным паролем")
    public void test10() throws InterruptedException {
        loginPage.loginIn("&f0()3u","sd8fs8d9uf");
        loginPage.checkUrl();//проверяем что остались на той же странице
    }

}
