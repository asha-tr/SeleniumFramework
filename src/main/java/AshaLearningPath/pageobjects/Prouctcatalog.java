package AshaLearningPath.pageobjects;

import AshaLearningPath.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Prouctcatalog extends AbstractComponent {
    WebDriver driver;
    public Prouctcatalog(WebDriver driver)
    {
        super(driver);
this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css =".mb-3")
    List<WebElement> products;
    By products1= By.cssSelector(".mb-3");
    By addTOCart= By.cssSelector(".card-body button:last-of-type");
    By toastMessage=By.id("toast-container");
    @FindBy(css=".ng-animating")
    WebElement spinner;

    public List<WebElement> getProductList()
    {
        waitForElementTOAppear(products1);
        return products;
    }
    public WebElement getProductName(String name)
    {
      WebElement prod=  getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
      return prod;
    }
    public void addProductTOCart( String name)
    {
        WebElement prod=getProductName(name);
        prod.findElement(addTOCart).click();
        waitForElementTOAppear(toastMessage);
        waitForElementTodisappear(spinner);
    }
}
