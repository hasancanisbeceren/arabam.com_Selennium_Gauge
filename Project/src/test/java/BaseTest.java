import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    @BeforeScenario
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options.addArguments("--disable-cookies");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--lang=en");
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        //options.addArguments("Headless");
        //options.addArguments("--window-size=2524,1094");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //webDriverWait = new WebDriverWait(driver,45,150);
        driver.manage().window().maximize();
        //driver.get(baseURL);
    }
    /*@AfterAll
    public void close(){
        driver.quit();
    }*/
}
