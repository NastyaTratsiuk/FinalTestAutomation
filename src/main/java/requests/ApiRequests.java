package requests;

import enums.APIMethods;
import enums.NameParameters;
import kong.unirest.HttpResponse;
import kong.unirest.MultipartBody;
import kong.unirest.json.JSONArray;
import utils.ApiUtils;
import utils.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiRequests {

    public static HttpResponse<String> getToken(int variant) {
        return ApiUtils.post(String.format("%s%s", Config.URL_API, APIMethods.TOKEN_GET.getValue()))
                .field(NameParameters.VARIANT.getName(), variant).asString();
    }

    public static JSONArray getJsonArrayTests(int projectId) {
        return ApiUtils.post(String.format("%s%s", Config.URL_API, APIMethods.TESTS_GET_JSON.getValue()))
                .field(NameParameters.PROJECT_ID.getName(), projectId)
                .asJson().getBody().getArray();
    }

    public static HttpResponse<String> addNewTest(String sid, String projectName, String testName, String methodName, String env,
                                                  String startTimeString, String browser) {
        return ApiUtils.post(String.format("%s%s", Config.URL_API, APIMethods.GET_TEST_ID.getValue()))
                .field(NameParameters.SID.getName(), sid).field(NameParameters.PROJECT_NAME.getName(), projectName)
                .field(NameParameters.TEST_NAME.getName(), testName).field(NameParameters.METHOD_NAME.getName(), methodName)
                .field(NameParameters.ENV.getName(), env).field(NameParameters.START_TIME.getName(), startTimeString)
                .field(NameParameters.BROWSER.getName(), browser).asString();
    }

    public static HttpResponse<String> sendingLogsTest(int testId, String logContent) {
        return  ApiUtils.post(String.format("%s%s", Config.URL_API, APIMethods.SENT_LOG.getValue()))
                .field(NameParameters.TEST_ID.getName(), testId).field(NameParameters.CONTENT.getName(), logContent).asString();
    }

    public static HttpResponse<String> sendingAttachmentTest(int testId, String attachmentContent, String contentType) {
        return ApiUtils.post(String.format("%s%s", Config.URL_API, APIMethods.SENT_ATTACHMENT.getValue()))
                .field(NameParameters.TEST_ID.getName(), testId).field(NameParameters.CONTENT.getName(), attachmentContent)
                .field(NameParameters.CONTENT_TYPE.getName(), contentType).asString();
    }
}