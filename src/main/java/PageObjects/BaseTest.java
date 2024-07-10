package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    String url = "https://rpachallenge.com/";
    String downloadFilePath = System.getProperty("user.dir") + "\\src\\test\\Resources";
    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // Set Chrome preferences to specify download directory
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", downloadFilePath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().minimize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(url);
        System.out.println(downloadFilePath);
    }

    @AfterClass
    public void tearDown() {

        File file = new File(downloadFilePath + "\\challenge.xlsx");

        if(file.exists()) {
            file.delete();
        }


        driver.quit();
    }
}
