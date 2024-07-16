package PageObjects;

import Utils.ExcelUtility;
import Utils.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class HomePage extends BaseTest{

   public HomePage(){
       PageFactory.initElements(driver, this);
   }

   @FindBy(xpath = "//label[contains(text(),'Company Name')]/following-sibling::input")
    public WebElement companyName;

   @FindBy(xpath = "//label[contains(text(),'Role')]/following-sibling::input")
    public WebElement roleInCompany;

   @FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::input")
    public WebElement phoneNumber;

   @FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::input")
    public WebElement emailAddress;

   @FindBy(xpath = "//label[contains(text(),'Last')]/following-sibling::input")
    public WebElement lastName;

   @FindBy(xpath = "//label[contains(text(),'First')]/following-sibling::input")
    public WebElement firstName;

   @FindBy(xpath = "//label[contains(text(),'Add')]/following-sibling::input")
    public WebElement address;

   @FindBy(xpath = "//button[contains(text(),'Start')]")
    public WebElement startButton;

   @FindBy(xpath = "//a[contains(text(),'Download')]")
    public WebElement downloadButton;

   @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton;

   @FindBy(xpath = "//button[contains(text(),'Round')]")
    public WebElement roundButton;

   @FindBy(xpath = "//button[contains(text(),'Reset')]")
    public WebElement resetButton;

   @FindBy(xpath = "//div[@class='message2']")
    public WebElement scoreMsg;

   public void downloadExcelFile(){
       downloadButton.click();
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }

   public void startGame(){
       startButton.click();
   }

   public int getRound(){
       String str  = roundButton.getText();
       int roundNumber = Integer.valueOf(str.split(" ")[1]);
       return roundNumber;
   }

   public void fillDetails() {
       ExcelUtility excelUtility = new ExcelUtility();
       HashMap map = excelUtility.readDataFromExcel(getRound());
       firstName.sendKeys(map.get("firstName").toString());
       lastName.sendKeys(map.get("lastName").toString());
       emailAddress.sendKeys(map.get("email").toString());
       phoneNumber.sendKeys(map.get("phoneNumber").toString());
       address.sendKeys(map.get("address").toString());
       roleInCompany.sendKeys(map.get("roleInCompany").toString());
       companyName.sendKeys(map.get("companyName").toString());


   }

   public void clickOnSubmitButton(){
       submitButton.click();
       while(Utility.isElementPresent(resetButton)==false){
           HomePage homePage = new HomePage();
           homePage.fillDetails();
           submitButton.click();
       }

   }


    public void getScore() {
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\result\\ScreenShot.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String msg = scoreMsg.getText();

        ExcelUtility excelUtility = new ExcelUtility();
        excelUtility.writeMessageToExcel(msg,excelFile);
        try {
            FileUtils.copyFile(excelFile, new File(System.getProperty("user.dir") + "\\result\\score.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(excelFile.exists()) {
            excelFile.delete();
        }

    }
}
