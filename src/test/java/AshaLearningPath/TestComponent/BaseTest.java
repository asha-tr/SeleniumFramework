package AshaLearningPath.TestComponent;

import AshaLearningPath.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public Landingpage landingpage;

    public WebDriver initializeDriver() throws IOException {


        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\AshaLearningPath\\resources\\GlobalData.properties");
        prop.load(fileInputStream);

        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();




        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public Landingpage launchApplication() throws IOException {
        driver = initializeDriver();
        landingpage = new Landingpage(driver);
        landingpage.goTOThisURL();
        return landingpage;
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty(("user.dir") + "//reports//" + testCaseName + ".png");


    }

}
