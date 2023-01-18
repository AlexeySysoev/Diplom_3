import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
public class RegisterTest {
    private WebDriver driver;
    WebDriverSet selectDriver  = new WebDriverSet();
    List<String> user = new ArrayList<>();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage= new ProfilePage();
    @Before
    public void preSettings(){
        driver = selectDriver.getWebDriver();
        driver.manage().window().maximize();
        user.add("Алексей"); user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase()+"@yandex.ru"); user.add("111111");
        mainPage.setDriver(driver);
        registerPage.setDriver(driver);
        loginPage.setDriver(driver);
        profilePage.setDriver(driver);
    }
    @Test
    @DisplayName("Проверка регистрации аккаунта с корректными данными")
    @Description("проверка входа в аккаунт после регистрации, сравнение логина(почты)")
    public void checkSuccessRegisterAccount(){
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
