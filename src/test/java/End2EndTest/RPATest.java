package End2EndTest;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import org.testng.annotations.Test;

public class RPATest extends BaseTest {
    public HomePage homePage;

    @Test
    public void RPAEnd2EndTest() throws Exception {
        homePage = new HomePage();
        homePage.downloadExcelFile();
        Thread.sleep(5000);

    }
}
