package utils;

import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import responses.JsonResponse;

public class ApiUtils {

    public static JsonResponse get(String requestPath) {
        HttpResponse<JsonNode> response = Unirest.get(requestPath).asJson();
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public static HttpRequestWithBody post(String route) {
        return Unirest.post(route);
    }

    public static void shutDown(){
        Unirest.shutDown();
    }
}
