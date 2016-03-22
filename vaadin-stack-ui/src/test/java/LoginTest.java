import de.eiswind.vaadin.spring.VaadinApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VaadinApplication.class)
@WebIntegrationTest
public class LoginTest {
    static {
        if (System.getProperty("webdriver.firefox.bin") == null) {
            System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
        }

    }

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void cleanup(){
        driver.close();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("http://localhost:8080");
        driver.findElement(By.id("customer")).sendKeys("tenant_1");
        driver.findElement(By.id("username")).sendKeys("tenant_1");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("signInButton")).click();

        Thread.sleep(1000);
    }
}
