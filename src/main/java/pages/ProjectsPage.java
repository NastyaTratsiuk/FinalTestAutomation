package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ProjectsPage extends Form {

    private static By lblProjectsPage = By.className("panel-heading");

    private final ILabel lblFooterVersion = getElementFactory().getLabel(By.xpath("//p[contains(@class,'footer-text')]/span"),
            "Footer version.");
    private final IButton btnAddProject = getElementFactory().getButton(By.xpath("//a[contains(@class,'btn-primary')]"),
            "Add button.");

    private final IButton btnProject(String nameProject) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@class='list-group']/a[contains(text(),'%s')]",
                nameProject)), "Project");
    }

    public ProjectsPage() {
        super(lblProjectsPage, "Projects page");
    }

    public String getLabelFooterVersion() {
        return lblFooterVersion.getText();
    }

    public void clickProject(String name) {
        btnProject(name).click();
    }

    public int getIdProject(String name) {
        String hrefAtr = btnProject(name).getAttribute("href");
        return Integer.parseInt(hrefAtr.split("projectId=")[1]);
    }

    public void clickBtnAddProject() {
        btnAddProject.click();
    }

    public boolean isDisplayNewProject(String nameProject) {
        return btnProject(nameProject).state().waitForDisplayed();
    }
}