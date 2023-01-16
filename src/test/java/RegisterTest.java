import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
public class RegisterTest {
    private WebDriver driver;
    List<String> user = new ArrayList<>();
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage= new ProfilePage();
    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        user.add("Алексей"); user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase()+"@yandex.ru"); user.add("111111");
        mainPage.setDriver(driver);
        registerPage.setDriver(driver);
        loginPage.setDriver(driver);
        profilePage.setDriver(driver);
    }
    @Test
    //Проверка успешной регистрации с корректными данными
    public void checkSuccessRegisterAccount(){
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        //Проверяем содержимое инпута поля логин(почта) на странице с логином для регистрации
        Assert.assertEquals(user.get(1), profilePage.getUserLogin(user.get(1)));
    }
    @After
    public void teardown(){
        //driver.quit();
    }
}
