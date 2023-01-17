import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TransitionFromProfilePageTest {
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
    //Проверка перехода из ЛК к конструктору
    public void constructorButtonClickFromProfilePageOnConstructorIsSuccess(){
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        mainPage.constructorButtonClick();
        Assert.assertTrue(driver.findElement(mainPage.fluoBun).isDisplayed()
                                && driver.getCurrentUrl().equals(urls.baseUrl));
    }
    @Test
    //Проверка перехода из ЛК к конструктору
    public void logoClickFromProfilePageOnConstructorIsSuccess(){
        registerPage.registerUser(user);
        loginPage.loginUser(user.get(1), user.get(2));
        mainPage.personalAccountLinkClick();
        mainPage.logoClick();
        Assert.assertTrue(driver.findElement(mainPage.fluoBun).isDisplayed()
                && driver.getCurrentUrl().equals(urls.baseUrl));
    }
}
