import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Feature("Test Mealplan")
public class mealPlanTest extends BaseTestSpooner{

    String apikey = "aec96fd2c9be4f649452a49962b1c27f";
    String username = "citra";
    String hash = "1690d5a0b3187106334cacf528be14dc78b73a62";

    @Test(description = "Test Meal Planner Generate")
    public void testMealPlannerGenerate(){
        given().queryParams("apiKey",apikey)
                .log().ifValidationFails()
                .when()
                .get("mealplanner/generate")
                .then()
                .statusCode(200)
                .body("week.monday.meals.size()",equalTo(3))
                .extract().response();

    }

    @Test(description = "Test Meal Planner Generate With Parameter")
    public void testMealPlannerParameterGenerate(){
        given().queryParams("apiKey",apikey)
                .queryParams("targetCalories", 1000)
                .queryParams("diet", "vegetarian")
                .log().ifValidationFails()
                .when()
                .get("mealplanner/generate")
                .then()
                .statusCode(200)
                .extract().response();

    }

    @Test(description = "Add Mealplan")
    public void testAddMealPlan(){
        String requestBody="{\n" +
                "    \"date\": 1589500800,\n" +
                "    \"slot\": 1,\n" +
                "    \"position\": 0,\n" +
                "    \"type\": \"INGREDIENTS\",\n" +
                "    \"value\": {\n" +
                "        \"ingredients\": [\n" +
                "            {\n" +
                "                \"name\": \"1 banana\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParams("apiKey",apikey)
                .queryParams("hash",hash)
                .body(requestBody)
                .when()
                .post("/mealplanner/{username}/items",username)
                .then().statusCode(200)
                .extract().response();


    }

    @Test(description = "Test Image Classification")
    public void testImageClassification(){
        given().queryParams("apiKey",apikey)
                .queryParams("imageUrl","https://t4.ftcdn.net/jpg/02/58/85/85/360_F_258858591_9cHoK7D35fpe4IO1JPyjXyuDV0HUMPSM.jpg")
                .log().ifValidationFails()
                .when()
                .get("food/images/classify")
                .then()
                .statusCode(200)
                .extract().response();

    }
}
