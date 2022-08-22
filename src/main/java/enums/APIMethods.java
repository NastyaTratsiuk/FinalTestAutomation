package enums;

public enum APIMethods {

    TOKEN_GET("/token/get/"),
    TESTS_GET_JSON("/test/get/json"),
    GET_TEST_ID("/test/put"),
    SENT_LOG("/test/put/log"),
    SENT_ATTACHMENT("/test/put/attachment");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    APIMethods(String value) {
        this.value = value;
    }
}