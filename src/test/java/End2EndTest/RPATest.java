package End2EndTest;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import Utils.ExcelUtility;
import org.testng.annotations.Test;

public class RPATest extends BaseTest {
    public HomePage homePage;


    @Test
    public void RPAEnd2EndTest() {
        homePage = new HomePage();
        homePage.downloadExcelFile();
        homePage.startGame();

        homePage.fillDetails();
        homePage.clickOnSubmitButton();

        homePage.getScore();

    }
}
