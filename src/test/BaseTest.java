import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: nrybchak
 * Date: 5/26/15
 * Time: 6:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest {

    protected static WebDriver driver;

    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    protected final String urlString = "http://www.ss.lv/";

    @BeforeClass
    public static void setUp() {
        try {
            logger.log(Level.INFO, "Set up method started");
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            logger.log(Level.INFO, "Set up method finished successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @AfterClass
    public static void tearDown() {
        logger.log(Level.INFO, "Driver is closing browser");
        driver.quit();
        logger.log(Level.INFO, "Driver closed browser");
    }
}
