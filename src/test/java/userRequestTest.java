import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Feature("User")
public class userRequestTest extends BaseTestUser{

    @Test(priority = 1)
    public void createUser() {
        String requestBody = "{\n" +
                "  \"id\": 1331,\n" +
                "  \"username\": \"Citra\",\n" +
                "  \"firstName\": \"Widya\",\n" +
                "  \"lastName\": \"Sucitra\",\n" +
                "  \"email\": \"widya.sucitra@finaccel.co\",\n" +
                "  \"password\": \"Sucitra123\",\n" +
                "  \"phone\": \"081234567822\",\n" +
                "  \"userStatus\": 1\n" +
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
    public void login(){

            given().contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("/login?username=rere&password=password")
                    .then()
                    .statusCode(200)
                    .extract().response();

        }
    @Test(priority = 3)
        public void getusername(){
            given().contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("/Citra")
                    .then()
                    .statusCode(200)
                    .extract().response();
        }

    @Test(priority = 4)
    public void updateUser() {
        String requestBody = "{\n" +
                "  \"id\": 1332,\n" +
                "  \"username\": \"Citra\",\n" +
                "  \"firstName\": \"Wiwid\",\n" +
                "  \"lastName\": \"Sucit\",\n" +
                "  \"email\": \"citra@mail.com\",\n" +
                "  \"password\": \"Sucitra123\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .log().ifValidationFails()
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(priority = 5)
    public void logoutUser(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/logout") // Adjust the endpoint based on your API
                .then()
                .statusCode(200)
                .extract().response();

    }

    @Test(priority = 6)
    public void deleteUser(){
        given()
                .header("api_key","some_key")
                .when()
                .delete("Citra")
                .then()
                .statusCode(200)
                .extract().response();
    }



    }
