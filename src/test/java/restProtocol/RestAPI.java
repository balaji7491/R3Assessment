package restProtocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.http.Status;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class RestAPI {

    String baseURI = "https://open.er-api.com";
    ObjectMapper objectMapper = new ObjectMapper();


    public RequestSpecification BASE(String servicePath){
        return given()
                .baseUri(baseURI).basePath(servicePath)
                .relaxedHTTPSValidation()
                .contentType("application/json");
    }

    //GET Methods implementation
    public Response GET(String servicePath, String endpoint, Integer statusCode){
       int expectedStatusCode = (statusCode != null)? statusCode: 200;
        return BASE(servicePath)
                .when()
                .get(endpoint)
                .then()
//                .log().all()
                .assertThat()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    public Response GET(String servicePath, String endpoint){
        return BASE(servicePath)
                .when()
                .get(endpoint)
                .then()
//                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public Response GET(String servicePath, Map<String,Object> queryParameter, String endpoint){
        return BASE(servicePath)
                .queryParams(queryParameter)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }

    public Response GET(String servicePath, Map<String,Object> queryParameter, String endpoint, Integer statusCode){
        int expectedStatusCode = (statusCode != null)? statusCode: 200;

        return BASE(servicePath)
                .queryParams(queryParameter)
                .when()
                .log().all()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

    //POST Methods implementation
    public Response POST(String servicePath, Map<String, Object> queryParameter, Map<String,Object> reqBody, String endpoint) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(reqBody);

        return BASE(servicePath)
                .queryParams(queryParameter)
                .body(payload)
                .log().all()
                .when().post(endpoint)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }

    public Response POST(String servicePath, Map<String, Object> queryParameter, Object reqBody, String endpoint) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(reqBody);

        return BASE(servicePath)
                .queryParams(queryParameter)
                .body(payload)
                .log().all()
                .when().post(endpoint)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }

    public Response POST(String servicePath, Map<String,Object> reqBody, String endpoint) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(reqBody);

        return BASE(servicePath)
                .body(payload)
                .log().all()
                .when().post(endpoint)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }

    public Response POST(String servicePath, Object reqBody, String endpoint) throws JsonProcessingException {
        String payload = objectMapper.writeValueAsString(reqBody);

        return BASE(servicePath)
                .body(payload)
                .log().all()
                .when().post(endpoint)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }

    public Response schemaValidation(String servicePath, String endpoint, String jsonSchemaString){
        return BASE(servicePath)
                .when()
                .get(endpoint)
                .then()
//                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaString))
                .extract().response();
    }
}

