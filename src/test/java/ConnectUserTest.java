import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConnectUserTest extends BaseTestSpooner{

    @Test(description = "Get Username and Hash")
    public void testConnectUser(){
        String apiKey = "aec96fd2c9be4f649452a49962b1c27f"; //di profile https://spoonacular.com/food-api/console#Profile
        String requestBody = "{\n" +
                "    \"username\": \"Citra\",\n" +
                "    \"firstName\": \"Widya\",\n" +
                "    \"lastName\": \"Sucitra\",\n" +
                "    \"email\": \"widya.sucitra@finaccel.co\"\n" +
                "}";

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParams("apiKey",apiKey)
                .body(requestBody)
//                .post("/connect")
                .post("users/connect")
                .then()
                .statusCode(200)
                .extract().response();




    }
}
