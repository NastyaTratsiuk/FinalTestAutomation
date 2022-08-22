package bases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;

public class BaseTest {

    @BeforeMethod
    public void startDriver() {
        BrowserUtils.driverMaximize();
    }

    @AfterClass
    public void closeDriver() {
        BrowserUtils.closeDriver();
    }
}
