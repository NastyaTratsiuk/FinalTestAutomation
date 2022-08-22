package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import enums.IndexesLocator;
import enums.KeyJSONArray;
import kong.unirest.json.JSONArray;
import models.Test;
import org.openqa.selenium.By;
import utils.SortUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NexagePage extends Form {

    private static By lblNaxagePage(String nameProject) {
        return By.xpath(String.format("//ol[@class= 'breadcrumb']/li[contains(text(),'%s')]", nameProject));
    }

    public List<IElement> testsAtThePageSite() {
        return getElementFactory().findElements(By.xpath("//table[@class = 'table']//th//following::tr"), ElementType.LABEL,
                ElementsCount.MORE_THEN_ZERO, ElementState.DISPLAYED);
    }

    public NexagePage(String nameProject) {
        super(lblNaxagePage(nameProject), nameProject + "page");
    }

    public List<Test> getListTestsFromPage() {
        List<Test> tests = new ArrayList<>();
        String locatorTable = "//table[@class = 'table']//th//following::tr";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            for (int i = 1; i < testsAtThePageSite().size() + 1; i++) {
                String name = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]/a",
                        locatorTable, i, IndexesLocator.TEST_NAME.getIndex())), "Name").getText();
                String method = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]",
                        locatorTable, i, IndexesLocator.METHOD_NAME.getIndex())), "Method").getText();
                String status = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]/span",
                        locatorTable, i, IndexesLocator.STATUS.getIndex())), "Status").getText();
                String startTimeString = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]",
                        locatorTable, i, IndexesLocator.START_TIME_STRING.getIndex())), "Start time").getText();
                String endTimeString = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]",
                        locatorTable, i, IndexesLocator.END_TIME_STRING.getIndex())), "End time").getText();
                String sid = AqualityServices.getElementFactory().getLabel(By.xpath(String.format("%s[%d]/td[%d]",
                        locatorTable, i, IndexesLocator.SID.getIndex())), "SID").getText();
                if (startTimeString.equals("")) {
                    tests.add(new Test(name, method, status, null, format.parse(endTimeString), sid));
                } else if (endTimeString.equals("")) {
                    tests.add(new Test(name, method, status, format.parse(startTimeString), null, sid));
                } else {
                    tests.add(new Test(name, method, status, format.parse(startTimeString), format.parse(endTimeString), sid));
                    System.out.println(format.parse(startTimeString));
                }
            }
        } catch (ParseException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return tests;
    }

    public List<Test> getListTestsFromAPI(JSONArray jsonArray) {
        List<Test> tests = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                String name = jsonArray.getJSONObject(i).getString(KeyJSONArray.TEST_NAME.getKey());
                String method = jsonArray.getJSONObject(i).getString(KeyJSONArray.METHOD_NAME.getKey());
                String status = jsonArray.getJSONObject(i).getString(KeyJSONArray.STATUS.getKey());
                String startTimeString = jsonArray.getJSONObject(i).getString(KeyJSONArray.START_TIME_STRING.getKey());
                String endTimeString = jsonArray.getJSONObject(i).getString(KeyJSONArray.END_TIME_STRING.getKey());
                String sid = jsonArray.getJSONObject(i).getString(KeyJSONArray.SID.getKey());
                if (startTimeString.equals("")) {
                    tests.add(new Test(name, method, status, null, format.parse(endTimeString), sid));
                } else if (endTimeString.equals("")) {
                    tests.add(new Test(name, method, status, format.parse(startTimeString), null, sid));
                } else {
                    tests.add(new Test(name, method, status, format.parse(startTimeString), format.parse(endTimeString), sid));
                }
            }
        } catch (ParseException e) {
            AqualityServices.getLogger().debug(e.getMessage());
        }
        return SortUtils.sortTestByDate(tests);
    }
}