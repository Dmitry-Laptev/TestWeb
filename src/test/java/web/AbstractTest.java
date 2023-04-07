package web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webPages.LoginPage;
import webPages.MyPostsPage;
import webPages.PostPage;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments(("--remote-allow-origins=*"));
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @BeforeEach
    void openPage() throws InterruptedException {

        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://test-stand.gb.ru/login"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

    @AfterAll
    static void close(){
        // driver.close();
        //driver.quit();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

}