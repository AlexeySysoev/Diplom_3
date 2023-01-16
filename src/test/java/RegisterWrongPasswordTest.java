import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class RegisterWrongPasswordTest {

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
            mainPage.setDriver(driver);
            registerPage.setDriver(driver);
            loginPage.setDriver(driver);
            profilePage.setDriver(driver);
        }
    @Parameterized.Parameter(0)
    public String password;
    @Parameterized.Parameters(name = "password: {0}")
    public static Object [][] wrongPass(){
        return new Object[][]{
                {""},
                {RandomStringUtils.randomAlphanumeric(1)},
                {RandomStringUtils.randomAlphanumeric(2)},
                {RandomStringUtils.randomAlphanumeric(3)},
                {RandomStringUtils.randomAlphanumeric(4)},
                {RandomStringUtils.randomAlphanumeric(5)},
        };
    }
        @Test
        //Проверка успешной регистрации с корректными данными
        public void enteringWrongPasswordReturnErrorMessage(){
            user.add("Алексей");
            user.add("lovewrongpass@yandex.ru");
            user.add(password);
            registerPage.registerUser(user);
            Assert.assertEquals("Некорректный пароль", registerPage.checkInvalidPasswordText());
           }
        @After
        public void teardown(){
            driver.quit();
        }
}

