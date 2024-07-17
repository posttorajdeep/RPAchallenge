package End2EndTest;

import PageObjects.BaseTest;
import PageObjects.HomePage;
import Utils.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RPATest extends BaseTest {
    public HomePage homePage;


    @Test
    public void RPAEnd2EndTest() {
        System.out.println("############## Test Start #############");
        homePage = new HomePage();
        homePage.downloadExcelFile();
        homePage.startGame();

        homePage.fillDetails();
        homePage.clickOnSubmitButton();

        homePage.getScore();
        Assert.assertTrue(homePage.scoreMsg.getText().contains("100%"));
        System.out.println("###################### Test Success ##################");

    }
}
