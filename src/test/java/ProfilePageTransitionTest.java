import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class ProfilePageTransitionTest {
    private WebDriver driver;
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
    public void profilePageTransitionWithLogin(){
        //создать юзера
        registerPage.registerUser(user);
        //залогиниться
        loginPage.loginUser(user.get(1), user.get(2));
        //перейти в лк с разных точек??

    }
    @Test
    public void profilePageTransitionWithoutLogin(){
       //создать юзера
        registerPage.registerUser(user);
       //пробовать перейти в лк с разных точек
    }
    @Test
    public void profilePageTransitionWithoutCreateUser(){
       //пробовать перейти в лк с разных точек
    }

}
