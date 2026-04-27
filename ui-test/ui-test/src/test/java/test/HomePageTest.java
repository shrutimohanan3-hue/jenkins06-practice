package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

    WebDriver driver;

    String BASE_URL = "http://localhost:5006";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
    }

    @Test
public void testPageLoads() {
    driver.get(BASE_URL);

    WebElement body = driver.findElement(By.tagName("body"));
    Assert.assertTrue(body.isDisplayed());
}

    @Test
    public void testBodyExists() {
        driver.get(BASE_URL);
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}