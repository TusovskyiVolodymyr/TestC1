import demoblaze.driver.DriverManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Configuration
@ComponentScan(value = "demoblaze")
@ContextConfiguration(classes = BaseTest.class)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeMethod
    public void beforeTestMethod() {
        DriverManager.getDriver().navigate().to("https://www.demoblaze.com/#");
    }

    @AfterMethod
    public void afterTestMethod() {
        DriverManager.tearDownDriver();
    }
}
