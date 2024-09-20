package AshaLearningPath.pageobjects;

import AshaLearningPath.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage extends AbstractComponent {
    WebDriver driver;

    public Landingpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submit;
    @FindBy(css="[class*='ng-tns-c4-17 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']")
    WebElement errorMessage;

    public Prouctcatalog loginPage(String email, String password) throws InterruptedException {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        Thread.sleep(500);
        submit.click();
        return new Prouctcatalog(driver);
    }

    public void goTOThisURL() {
        driver.get("https://rahulshettyacademy.com/client");
    }
    public String  getErrorMessage()
    {
       return errorMessage.getText();
    }
}
