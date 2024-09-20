package AshaLearningPath.pageobjects;

import AshaLearningPath.TestComponent.BaseTest;
import AshaLearningPath.TestComponent.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SimpleTest extends BaseTest {
    @Test
    public void testSimpleMethod() {
        System.out.println("Simple TestNG test is running!");
    }

    @Test(groups = {"ErrorHandling"})
    public void firstMethod() throws IOException, InterruptedException {
        String name = "ZARA COAT 3";
        landingpage.loginPage("asharam9740@gmail.com", "Arjun@170");
        Thread.sleep(500);
        Assert.assertEquals("Incorrect Email and Password.", landingpage.getErrorMessage());
    }
}

