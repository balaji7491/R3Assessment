package restProtocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import restProtocol.RestAPI;

import java.util.List;
import java.util.Map;

public abstract class Base extends RestAPI {

    //Abstract methods
    protected abstract String getServicePath();

/*
Concrete methods
GET Calls overloaded methods
*/

    protected Response get(String endpoint){
        return GET(getServicePath(), endpoint);
    }

    protected Response get(String token, String endpoint){
        return GET(getServicePath(), endpoint);
    }

    protected Response get(Map<String, Object> query, String endpoint){
        return GET(getServicePath(), query, endpoint);
    }


    //POST Calls overloaded methods

    protected Response post(List<Object> requestBody, String endpoint) throws JsonProcessingException {
        return POST(getServicePath(), requestBody, endpoint);
    }
    protected Response post(String endpoint, Map<String, Object> requestBody) throws JsonProcessingException {
        return POST(getServicePath(), requestBody, endpoint);
    }

    protected Response post(Map<String, Object> reqBody, String endpoint) throws JsonProcessingException {
        return POST( getServicePath(), reqBody, endpoint);
    }

    protected Response post(Map<String, Object> query, Object requestBody, String endpoint) throws JsonProcessingException {
        return POST(getServicePath(), query, requestBody, endpoint);
    }

    protected Response post(Map<String, Object> query, Map<String,Object> requestBody, String endpoint) throws JsonProcessingException {
        return POST(getServicePath(), query, requestBody, endpoint);
    }

}

