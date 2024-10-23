import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("Pet Module")
public class petRequestTest extends BaseTest{

    @Test(priority = 1)
    public void addPetTest(){
        String requestBody = "{\n" +
                "  \"id\": 131,\n" +
                "  \"category\": {\n" +
                "    \"id\": 132,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"kucing\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .log().ifValidationFails()
                .when()
                .post()
                .then()
                .statusCode(200);

    }

    @Test(priority = 2)
    public void findPetByIdTest(){
        given().contentType(ContentType.JSON)
            .accept(ContentType.JSON)
                .when()
                .get("/131")
                .then()
                .statusCode(200)
                .extract().response();

        }
        @Test(priority = 3)
    public void updatePetTest(){
        String requestBody = "{\n" +
                "  \"id\": 131,\n" +
                "  \"category\": {\n" +
                "    \"id\": 132,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"kucing\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}";
            given().contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(requestBody)
                    .log().ifValidationFails()
                    .when()
                    .put()
                    .then()
                    .statusCode(200)
                    .extract().response();

        }

        @Test(priority = 4)
    public void findPetByStatusTest()
        {
            given().contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("/findByStatus?status=sold")
                    .then()
                    .statusCode(200)
                    .extract().response();
        }
       @Test(priority = 5)
    public void deletePetTest(){
        given()
                .header("api_key","some_key")
                .when()
                .delete("131")
                .then()
                .statusCode(200)
                .extract().response();
       }


    }

