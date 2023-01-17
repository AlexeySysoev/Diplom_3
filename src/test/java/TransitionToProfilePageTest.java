import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
public class TransitionToProfilePageTest {
    private WebDriver driver;
    Urls urls = new Urls();
    List<String> user = new ArrayList<>();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage= new ProfilePage();
    @Before
    public void preSettings() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        user.add("Алексей");
        user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@yandex.ru");
        user.add("111111");
        mainPage.setDriver(driver);
        registerPage.setDriver(driver);
        loginPage.setDriver(driver);
        profilePage.setDriver(driver);
    }
    @Test
    //Проверка перехода в лк с регистрацией и логином в системе
    //Дубль теста из LoginTest
    public void profilePageTransitionWithLogin(){
        //создать юзера
        registerPage.registerUser(user);
        //залогиниться
        loginPage.loginUser(user.get(1), user.get(2));
        //перейти в лк и проверить почту
        mainPage.personalAccountLinkClick();
        //Проверяем содержимое инпута поля логин(почта) на странице с логином для регистрации
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @Test
    //Проверяем переход на страницу Логина при нажатии кнопки Личный кабинет без авторизации
    public void profilePageTransitionWithoutLogin(){
       registerPage.registerUser(user);
       mainPage.personalAccountLinkClick();
       //Проверим, что произошел переход на страницу Логина
       Assert.assertTrue(driver.getCurrentUrl().equals(urls.baseUrl+urls.loginPoint));
    }
    @Test
    //Проверяем переход на страницу Логина при нажатии кнопки Личный кабинет без создания юзера
    public void profilePageTransitionWithoutCreateUser(){
       //Попытка зайти в Личный кабинет
        mainPage.open();
        mainPage.personalAccountLinkClick();
        //Проверим, что произошел переход на страницу Логина
        Assert.assertEquals(urls.baseUrl + urls.loginPoint, driver.getCurrentUrl());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
