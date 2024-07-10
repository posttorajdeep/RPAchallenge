package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

   public void downloadExcelFile(){
       downloadButton.click();
   }



}
