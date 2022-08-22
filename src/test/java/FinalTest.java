import aquality.selenium.browser.AqualityServices;
import bases.BaseTest;
import enums.NameFiles;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewProjectPage;
import pages.NexagePage;
import pages.ProjectsPage;
import pages.form.AddProjectForm;
import requests.ApiRequests;
import utils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalTest extends BaseTest {

    @Test
    public void testCaseFinalTask() {
        ApiRequests.getToken(Config.VARIANT);
        Assert.assertNotNull(ApiRequests.getToken(Config.VARIANT).getBody(), "Token is null.");

        BrowserUtils.goTo(Config.URL_LOGIN_PASSWORD);
        BrowserUtils.addCookie("token", ApiRequests.getToken(Config.VARIANT).getBody());
        BrowserUtils.refresh();
        ProjectsPage projectsPage = new ProjectsPage();
        Assert.assertTrue(projectsPage.state().waitForDisplayed(), "Projects page isn't open.");
        Assert.assertEquals(projectsPage.getLabelFooterVersion(), JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(),
                "/footerVersion"), "Footer versions are not the same.");

        projectsPage.clickProject(JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/project"));
        NexagePage nexagePage = new NexagePage(JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/project"));
        Assert.assertEquals(nexagePage.getListTestsFromPage(), SortUtils.sortTestByDate(nexagePage.getListTestsFromPage()),
                "List isn't sorted by date descending");
        ApiRequests.getJsonArrayTests(projectsPage.getIdProject(JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/project")));
        Assert.assertTrue(nexagePage.getListTestsFromAPI(ApiRequests.getJsonArrayTests(projectsPage.getIdProject
                                (JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/project"))))
                        .subList(0, nexagePage.getListTestsFromPage().size()).equals(nexagePage.getListTestsFromPage()),
                "List tests from page and from API are different.");

        BrowserUtils.goBack();
        projectsPage.clickBtnAddProject();
        BrowserUtils.switchToLastTabs();
        AddProjectForm addProjectForm = new AddProjectForm();
        addProjectForm.inputProjectName(RandomUtils.generateString(Integer.parseInt(JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(),
                "/randomSize"))));
        addProjectForm.clickSaveProject();
        Assert.assertTrue(addProjectForm.isDisplaySuccessMessage(), "Message isn't display.");
        JavaScriptUtils.closePopUp();
        BrowserUtils.switchToLastTabs();
        BrowserUtils.refresh();
        Assert.assertTrue(projectsPage.isDisplayNewProject(addProjectForm.getProjectName()), "New project isn't display");

        projectsPage.clickProject(addProjectForm.getProjectName());
        NewProjectPage newProjectPage = new NewProjectPage(addProjectForm.getProjectName());
        newProjectPage.setTestId(Integer.parseInt(ApiRequests.addNewTest(new Date().toString(), addProjectForm.getProjectName(),
                Config.TEST_NAME, Config.METHOD_NAME, Config.ENV, new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()),
                Config.BROWSER).getBody()));
        ApiRequests.sendingLogsTest(newProjectPage.getTestId(), RandomUtils.generateString(Integer.parseInt(JsonParseUtils.
                getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/randomSize"))));
        ApiRequests.sendingAttachmentTest(newProjectPage.getTestId(),
                ((TakesScreenshot) AqualityServices.getBrowser().getDriver()).getScreenshotAs(OutputType.BASE64),
                Config.CONTENT_TYPE);
        Assert.assertTrue(newProjectPage.isTestIdDisplay(newProjectPage.getTestId()), "Test isn't display.");
        ApiUtils.shutDown();
    }
}