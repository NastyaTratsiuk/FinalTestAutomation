package models;

import java.util.Date;
import java.util.Objects;

public class Test {

    private int id;
    private String testName;
    private String testMethod;
    private String status;
    private Date startTime;
    private Date endTime;
    private String sid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Test(String testName, String testMethod, String status, Date startTime, Date endTime, String sid) {
        this.testName = testName;
        this.testMethod = testMethod;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testName='" + testName + '\'' +
                ", testMethod='" + testMethod + '\'' +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", sid='" + sid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testName, test.testName) && Objects.equals(testMethod, test.testMethod)
                && Objects.equals(status, test.status) && Objects.equals(startTime, test.startTime)
                && Objects.equals(endTime, test.endTime) && Objects.equals(sid, test.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testName, testMethod, status, startTime, endTime, sid);
    }
}