package AshaLearningPath.pageobjects;

import AshaLearningPath.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orderpage extends AbstractComponent {
    WebDriver driver;
    public Orderpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;

    @FindBy(css=".totalRow button")
            WebElement checkOut;

    public Boolean displayOrderDetails(String name)
    {

        Boolean match=  productNames.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(name));
        return match;

    }


}
