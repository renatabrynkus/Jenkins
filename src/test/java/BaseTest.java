import configuration.ApplicationProperties;
import configuration.DriverHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static WebDriver driver;
    protected static DriverHandler driverHandler;
    private static ApplicationProperties applicationProperties;

    @BeforeAll
    static void beforeAll() {
        applicationProperties = ApplicationProperties.getInstance();
        driverHandler = new DriverHandler();
        driver = driverHandler.getDriver();
        driver.get(System.getProperty("appUrl"));
    }

    @AfterAll
    static void quit() {
        driver.quit();
    }
}
