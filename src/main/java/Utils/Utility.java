package Utils;

import PageObjects.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public static boolean isElementPresent(WebElement webelement) {
        boolean exists = false;
        try {
            webelement.getTagName();
            exists = true;
        } catch (NoSuchElementException e) {
            // nothing to do.
        }
        return exists;
    }
}
