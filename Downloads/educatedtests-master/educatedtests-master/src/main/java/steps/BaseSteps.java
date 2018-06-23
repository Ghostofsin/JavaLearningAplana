package steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;
    protected static String BaseURL;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @BeforeClass
    public static void BeforeTest() {


        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        BaseURL = properties.getProperty("app.url");
 //       BaseURL = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BaseURL);
    }


    @AfterClass
    public static void AfterTest() {
        driver.quit();
    }


    public void fillfields(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}