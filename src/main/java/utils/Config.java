package utils;

import enums.NameFiles;

public class Config {

    public static String URL_WEB = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/urlWeb");
    public static String URL_API = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/urlApi");
    public static Integer VARIANT = Integer.valueOf(JsonParseUtils.getElementFromJsonParse(NameFiles.TESTING.getNameFile(), "/variant"));
    public static String URL_LOGIN_PASSWORD = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/urlWithLoginPassword");
    public static String ENV = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/env");
    public static String BROWSER = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/browser");
    public static String TEST_NAME = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/testName");
    public static String METHOD_NAME = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/methodName");
    public static String CONTENT_TYPE = JsonParseUtils.getElementFromJsonParse(NameFiles.CONFIG.getNameFile(), "/contentType");
}