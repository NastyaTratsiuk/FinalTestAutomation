package enums;

public enum NameParameters {

    VARIANT("variant"),
    PROJECT_NAME("projectName"),
    PROJECT_ID("projectId"),
    TEST_ID("testId"),
    METHOD_NAME("methodName"),
    TEST_NAME("testName"),
    SID("SID"),
    ENV("env"),
    START_TIME("startTime"),
    BROWSER("browser"),
    CONTENT("content"),
    CONTENT_TYPE("contentType");

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    NameParameters(String name) {
        this.name = name;
    }
}