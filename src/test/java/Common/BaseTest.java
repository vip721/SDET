package Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

     public static WebDriver driver;
    @Before
    public static void initializeDriver(){
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

}
