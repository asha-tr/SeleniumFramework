package AshaLearningPath.pageobjects;

import AshaLearningPath.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Cartpage extends AbstractComponent {
    WebDriver driver;
    public Cartpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".cartSection h3")
    List<WebElement> productTitles;

    @FindBy(css=".totalRow button")
            WebElement checkOut;

    public Boolean displayProductDetails(String name)
    {

        Boolean match=  productTitles.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(name));
        return match;

    }
    public Checkoutpage checkOut()
    {
        checkOut.click();
        return new Checkoutpage(driver);

    }

}
