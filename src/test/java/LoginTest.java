import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    private WebDriver driver;
    Urls urls = new Urls();
    List<String> user = new ArrayList<>();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage= new ProfilePage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        user.add("Алексей");
        user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase()+"@yandex.ru");
        user.add("111111");
        mainPage.setDriver(driver);
        registerPage.setDriver(driver);
        loginPage.setDriver(driver);
        profilePage.setDriver(driver);
        forgotPasswordPage.setDriver(driver);
        //регистрация пользователя
        registerPage.registerUser(user);
    }
    @Test
    public void successLoginThroughAccountButton(){
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.loginUser(user.get(1), user.get(2)); //логин в системе
        mainPage.personalAccountLinkClick();
        //Проверяем успешный вход
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @Test
    public void successLoginThroughPersonalAccountButton(){
        mainPage.open();
        mainPage.personalAccountLinkClick();
        loginPage.loginUser(user.get(1), user.get(2)); //логин в системе
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        //Проверяем успешный вход
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @Test
    public void successLoginThroughEnterLinkInRegisterForm(){
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.registerLinkClick();
        registerPage.enterLinkClick();
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        //Проверяем успешный вход
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @Test
    public void successLoginThroughForgotPasswordLink(){
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.forgotPasswordLinkClick();
        forgotPasswordPage.enterLinkClick();
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        //Проверяем успешный вход
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @Test
    public void logoutFromAccountIsDone(){
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.personalAccountLink);
        mainPage.personalAccountLinkClick();
        profilePage.logoutButtonClick();
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(urls.baseUrl+urls.loginPoint, driver.getCurrentUrl());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
