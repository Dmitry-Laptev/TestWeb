package web;

import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webPages.LoginPage;
import webPages.MyPostsPage;
import webPages.PostPage;

public class MyPostsTest extends AbstractTest {
    LoginPage loginPage;
    MyPostsPage myPostsPage;
    PostPage postPage;
    protected String username = "GB202303ebb5d1012";
    protected String password = "c230717d87";

    @BeforeEach
    void init() {
        loginPage = new LoginPage(getWebDriver());
        myPostsPage = new MyPostsPage(getWebDriver());
        postPage = new PostPage(getWebDriver());
    }

    @Test
    @Story("Мои публикации")
    @DisplayName("1: Next page")
    public void test1() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.toNextPage();
        myPostsPage.checkToNextPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("2: Preview Post")
    public void test2() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.checkPosts();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("3: Previous page")
    public void test3() throws InterruptedException {
        loginPage.loginIn(username,password);
        myPostsPage.moveToPreviousPage();
        myPostsPage.checkMoveToPreviousPage();

    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("4: Open post")
    public void test4() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.clickPost();
        postPage.checkMoveToPostPage();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("5: Sorting posts")
    public void test5() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.clickOrder();
        myPostsPage.checkOrderDESC();
        myPostsPage.clickOrderOn();
        myPostsPage.checkOrderASC();

    }

    @Test
    @Story("Лента своих постов")
    @DisplayName("6: Foreign posts")
    public void test6() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.moveNotMyPostsPage();
        myPostsPage.checkMoveNotMyPostsPage();
    }
    @Test
    @Story("Лента своих постов")
    @DisplayName("7: Home page")
    public void test7() throws InterruptedException {
        loginPage.loginIn(username, password);
        myPostsPage.moveNotMyPostsPage();
        myPostsPage.moveToHomePage();
        myPostsPage.checkMoveToHomePage();
    }


}
