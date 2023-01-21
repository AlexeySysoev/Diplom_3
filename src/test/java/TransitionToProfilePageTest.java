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

public class TransitionToProfilePageTest {
    private WebDriver driver;
    WebDriverSet selectDriver = new WebDriverSet();
    Urls urls = new Urls();
    List<String> user = new ArrayList<>();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();

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
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет с регистрацией и логином в системе/ Дубль теста из сьюта LoginTest")
    @Description("сверяем логин юзера после входа в аккаунт")
    public void profilePageTransitionWithLogin() {
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет без входа в систему")
    @Description("ожидаем, что произошел переход на страницу входа в аккаунт")
    public void profilePageTransitionWithoutLogin() {
        registerPage.registerUser(user);
        mainPage.personalAccountLinkClick();
        Assert.assertTrue(driver.getCurrentUrl().equals(urls.baseUrl + urls.loginPoint));
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет без создания аккаунта и входа в систему")
    @Description("ожидаем, что произошел переход на страницу входа в аккаунт")
    public void profilePageTransitionWithoutCreateUser() {
        mainPage.open();
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(urls.baseUrl + urls.loginPoint, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
