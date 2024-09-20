package AshaLearningPath.AbstractComponent;

import AshaLearningPath.pageobjects.Cartpage;
import AshaLearningPath.pageobjects.Orderpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="[routerlink*='cart']")
            WebElement header;
    @FindBy(css="[routerlink*='myorders']")
    WebElement Orderheader;


    public void waitForElementTOAppear(By findBy)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForWebElementTOAppear(WebElement findBy)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public  void waitForElementTodisappear(WebElement ele)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
    public Cartpage goToCart()
    {
header.click();
        Cartpage cartpage=new Cartpage(driver);
        return cartpage;
    }
    public Orderpage goToOrderPage()
    {
        Orderheader.click();
        Orderpage orderpage=new Orderpage(driver);
        return orderpage;
    }
}
