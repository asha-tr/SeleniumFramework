package AshaLearningPath.pageobjects;

import AshaLearningPath.TestComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class StandAloneTest extends BaseTest {

    String name = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void firstMethod(String email, String password, String productName) throws IOException, InterruptedException {

        Prouctcatalog productcatalog = landingpage.loginPage(email, password);
        productcatalog.getProductList();
        productcatalog.addProductTOCart(productName);
        Cartpage cartpage = productcatalog.goToCart();

        Boolean match = cartpage.displayProductDetails(productName);
        Assert.assertTrue(match);
        Checkoutpage checkoutpage = cartpage.checkOut();
        checkoutpage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutpage.submitOrder();
        String confirmMessage = confirmationPage.confirmationMessage();

        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
    }

    @Test(dependsOnMethods = {"firstMethod"})
    public void orderHistoryTest() throws InterruptedException {
        Prouctcatalog productcatalog = landingpage.loginPage("asharam9740@gmail.com", "Arjun@1709");
        Orderpage orderpage = productcatalog.goToOrderPage();
        Assert.assertTrue(orderpage.displayOrderDetails(name));
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"asharam9740@gmail.com", "Arjun@1709", "ZARA COAT 3"}, {"asharam9740@gmail.com", "Arjun@1709", "ADIDAS ORIGINAL"}};
    }
}
