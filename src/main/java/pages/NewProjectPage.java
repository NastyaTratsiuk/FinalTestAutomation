package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NewProjectPage extends Form {

    int testId;

    private static By lblNewProjectPage(String nameProject) {
        return By.xpath(String.format("//ol[@class= 'breadcrumb']/li[contains(text(),'%s')]", nameProject));
    }

    private final IButton btnTest(int testId) {
        return getElementFactory().getButton(By.xpath(String.format("//a[@href = 'testInfo?testId=%s']", testId)),
                "Project");
    }

    public NewProjectPage(String nameProject) {
        super(lblNewProjectPage(nameProject), "New project page");
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public boolean isTestIdDisplay(int testId) {
        return btnTest(testId).state().waitForDisplayed();
    }
}