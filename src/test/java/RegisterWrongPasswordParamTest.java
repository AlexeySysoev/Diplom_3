import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class RegisterWrongPasswordParamTest {
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
            mainPage.setDriver(driver);
            registerPage.setDriver(driver);
            loginPage.setDriver(driver);
            profilePage.setDriver(driver);
        }
    @Parameterized.Parameter(0)
    public String password;
    @Parameterized.Parameter(1)
    public boolean result;
    @Parameterized.Parameters(name = "password: {0}, result: {1}")
    public static Object [][] wrongPass(){
        return new Object[][]{
                {"", true},
                {RandomStringUtils.randomAlphanumeric(1), true},
                {RandomStringUtils.randomAlphanumeric(2), true},
                {RandomStringUtils.randomAlphanumeric(3), true},
                {RandomStringUtils.randomAlphanumeric(4), true},
                {RandomStringUtils.randomAlphanumeric(5), true},
                {RandomStringUtils.randomAlphanumeric(6), false}
        };
    }
        @Test
        @DisplayName("Проверка сообщения об ошибке при вводе пароля менее 6 символов")
        @Description("проверяем наличие сообщения об ошибке")
        @Issue("Bug-001 - при пустом пароле сообщение не отображается, если не вводить пароль")
        public void enteringWrongPasswordReturnErrorMessage(){
            user.add("Алексей");
            user.add(RandomStringUtils.randomAlphabetic(10).toLowerCase()+"@yandex.ru");
            user.add(password);
            registerPage.registerUser(user);
            Assert.assertEquals("Empty - must be Error message!!!", result, registerPage.checkInvalidPasswordText());
           }
        @After
        public void teardown(){
            driver.quit();
        }
}

