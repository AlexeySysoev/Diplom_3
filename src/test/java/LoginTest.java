import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    private WebDriver driver;
    private WebDriverSet selectDriver = new WebDriverSet();
    private Urls urls = new Urls();
    private List<String> user = new ArrayList<>();
    private MainPage mainPage = new MainPage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ProfilePage profilePage = new ProfilePage();
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Before
    public void preSettings() {
        driver = selectDriver.getWebDriver();
        driver.manage().window().maximize();
        user.add("Алексей");
        user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@yandex.ru");
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
    @DisplayName("Проверка перехода в аккаунт через кнопку 'Войти в аккаунт'")
    @Description("проверяем логин в системе после перехода по кнопке")
    public void successLoginThroughAccountButton() {
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.loginUser(user.get(1), user.get(2)); //логин в системе
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }

    @Test
    @DisplayName("Проверка перехода в аккаунт через кнопку 'Личный кабинет'")
    @Description("проверяем логин в системе после перехода по кнопке")
    public void successLoginThroughPersonalAccountButton() {
        mainPage.open();
        mainPage.personalAccountLinkClick();
        loginPage.loginUser(user.get(1), user.get(2)); //логин в системе
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }

    @Test
    @DisplayName("Проверка перехода в аккаунт через ссылку 'Войти' в форме регистрации")
    @Description("проверяем логин в системе после перехода по ссылке")
    public void successLoginThroughEnterLinkInRegisterForm() {
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.registerLinkClick();
        registerPage.enterLinkClick();
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }

    @Test
    @DisplayName("Проверка перехода в аккаунт ссылку 'Войти' в форме восстановления пароля")
    @Description("проверяем логин в системе после перехода по ссылке")
    public void successLoginThroughForgotPasswordLink() {
        mainPage.open();
        mainPage.enterAccountButtonClick(); //кнопка Войти в аккаунт
        loginPage.forgotPasswordLinkClick();
        forgotPasswordPage.enterLinkClick();
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.fluBun);
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта через кнопку 'Выйти' в личном кабинете")
    @Description("проверяем адрес текущей страницы после перехода")
    public void logoutFromAccountIsDone() {
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.waitElement(mainPage.personalAccountLink);
        mainPage.personalAccountLinkClick();
        profilePage.logoutButtonClick();
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(urls.baseUrl + urls.loginPoint, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
