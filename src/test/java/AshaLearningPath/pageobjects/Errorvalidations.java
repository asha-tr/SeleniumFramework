package AshaLearningPath.pageobjects;

import AshaLearningPath.TestComponent.BaseTest;
import AshaLearningPath.TestComponent.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Errorvalidations extends BaseTest {



    @Test(groups = {"ErrorHandling"},retryAnalyzer= Retry.class)
        public void firstMethod() throws IOException,InterruptedException {
//
        String name="ZARA COAT 3";
//        ;
        landingpage.loginPage("asharam9740@gmail.com","Arjun@170");
//

     Assert.assertEquals("Incorrect Email  Password.",landingpage.getErrorMessage());




    }
}
