package AshaLearningPath.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Submitordertest {
    public static void main(String[] args) {

        firstMethod();
}
        public static void firstMethod()
    {

        WebDriver driver=new ChromeDriver();
        String name="ZARA COAT 3";
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        Landingpage landingpage=new Landingpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("userEmail")).sendKeys("asharam9740@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Arjun@1709");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
  List<WebElement> itemsList= driver.findElements(By.cssSelector(".mb-3"));
       WebElement items=itemsList.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
       items.findElement(By.cssSelector(".card-body button:last-of-type")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(".ng-animating")));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
       List<WebElement> cartItems= driver.findElements(By.cssSelector(".cartSection h3"));
     Boolean match=  cartItems.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(name));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(" Thankyou for the order. "));
        driver.close();



    }
}
