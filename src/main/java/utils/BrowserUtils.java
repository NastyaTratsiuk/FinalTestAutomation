package utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

public class BrowserUtils {

    public static void goTo(String url){
        AqualityServices.getBrowser().goTo(url);
    }

    public static void driverMaximize() {
        AqualityServices.getBrowser().maximize();
    }

    public static void closeDriver() {
        AqualityServices.getBrowser().quit();
    }

    public static void refresh(){
        AqualityServices.getBrowser().refresh();
    }

    public static void addCookie(String name, String value){
        AqualityServices.getBrowser().getDriver().manage().addCookie(new Cookie(name, value));
    }

    public static void goBack(){
        AqualityServices.getBrowser().goBack();
    }

    public static void switchToLastTabs(){
        AqualityServices.getBrowser().tabs().switchToLastTab();
    }
}
