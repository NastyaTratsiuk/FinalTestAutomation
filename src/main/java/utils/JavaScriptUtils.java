package utils;

import aquality.selenium.browser.AqualityServices;

public class JavaScriptUtils {

    public static void closePopUp() {
        AqualityServices.getBrowser().executeScript("window.close()");
    }
}