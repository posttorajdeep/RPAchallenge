package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {
    Properties prop = null;
    FileInputStream fis = null;
    public File excelFile = null;
    public BaseTest() {
        String file = System.getProperty("user.dir") + "\\src\\main\\Resources\\config.properties";
        try {
            fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
            excelFile = new File(downloadFilePath + "\\challenge.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver driver;

    public String downloadFilePath = System.getProperty("user.dir")+"\\src\\test\\Resources";

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        // Set Chrome preferences to specify download directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get(prop.getProperty("url"));
        if(excelFile.exists()) {
            excelFile.delete();
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
