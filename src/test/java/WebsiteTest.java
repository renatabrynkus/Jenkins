import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(WebsiteTest.class);

    @Test
    void shouldDisplayCorrectTitle() {
        logger.info("------> Test started");
        String actualTitle = driver.getTitle();
        logger.info("------> Actual title: {}", actualTitle);
        logger.info("------> Expected title: {}", System.getProperty("expectedTitle"));
        assertThat(actualTitle).isEqualTo(System.getProperty("expectedTitle"));
    }
}
