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

public class TransitionFromProfilePageTest {
    private WebDriver driver;
    private WebDriverSet selectDriver = new WebDriverSet();
    private Urls urls = new Urls();
    private List<String> user = new ArrayList<>();
    private MainPage mainPage = new MainPage();
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private ProfilePage profilePage = new ProfilePage();

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
    @DisplayName("Проверка перехода из личного кабинета к конструктору через иконку конструктора")
    @Description("проверяем адрес текущей страницы и отображение ингредиента")
    public void constructorButtonClickFromProfilePageOnConstructorIsSuccess() {
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        mainPage.constructorButtonClick();
        Assert.assertTrue(driver.findElement(mainPage.fluBun).isDisplayed()
                && driver.getCurrentUrl().equals(urls.baseUrl));
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета к конструктору через логотип stellar burgers")
    @Description("проверяем адрес текущей страницы и отображение ингредиента")
    public void logoClickFromProfilePageOnConstructorIsSuccess() {
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        mainPage.logoClick();
        Assert.assertTrue(driver.findElement(mainPage.fluBun).isDisplayed()
                && driver.getCurrentUrl().equals(urls.baseUrl));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
