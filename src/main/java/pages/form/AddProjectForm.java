package pages.form;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectForm extends Form {

    private String projectName;

    private static By lblAddProjectForm = By.xpath("//form[@id = 'addProjectForm']");

    private final ITextBox txbProjectName = getElementFactory().getTextBox(By.xpath("//input[@id = 'projectName']"),
            "Input project name.");
    private final IButton btnSaveProject = getElementFactory().getButton(By.xpath("//button[@type = 'submit']"),
            "Save project");
    private final ILabel lblSuccessMessage = getElementFactory().getLabel(By.xpath("//div[contains(@class,'alert-success')]"),
            "Success message.");

    public AddProjectForm() {
        super(lblAddProjectForm, "Add project form");
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void inputProjectName(String name) {
        txbProjectName.sendKeys(name);
        setProjectName(name);
    }

    public void clickSaveProject() {
        btnSaveProject.click();
    }

    public boolean isDisplaySuccessMessage() {
        return lblSuccessMessage.state().isDisplayed();
    }
}