package enums;

public enum KeyJSONArray {

    TEST_NAME("name"),
    METHOD_NAME("method"),
    STATUS("status"),
    START_TIME_STRING("startTime"),
    END_TIME_STRING("endTime"),
    SID("duration");

    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    KeyJSONArray(String key) {
        this.key = key;
    }
}