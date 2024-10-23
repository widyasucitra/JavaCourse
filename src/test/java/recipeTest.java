import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


@Feature("Test Recipe")
public class recipeTest extends BaseTestSpooner{
    String apiKey = "aec96fd2c9be4f649452a49962b1c27f";
//    String username = "citra";
//    String hash = "1690d5a0b3187106334cacf528be14dc78b73a62";

    @Test(description = "Test Recipe Search")
    public void testRecipeSearch() {
        given().queryParam("apiKey", apiKey)
                .queryParam("query", "noodle")
                .queryParam("maxFat", 25)
                .queryParam("number", 2)
                .log().ifValidationFails()
                .when()
                .get("recipes/complexSearch")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Test(description = "Test Recipe Search by Nutrients")
    public void testRecipeSearchNutrients() {
        given().queryParam("apiKey", apiKey)
                .queryParam("minCarbs", 10)
                .queryParam("maxCarbs", 50)
                .queryParam("number", 2)
                .log().ifValidationFails()
                .when()
                .get("recipes/findByNutrients")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Test(description = "Test Recipe Search by Ingredients")
    public void testRecipeSearchIngredients() {
        given().queryParam("apiKey", apiKey)
                .queryParam("ingredients", "rice", "oil", "egg")
                .queryParam("number", 2)
                .log().ifValidationFails()
                .when()
                .get("recipes/findByIngredients")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Test(description = "Test Recipe Information")
    public void testRecipeInformation() {
        given().queryParam("apiKey", apiKey)
                .queryParam("includeNutrition", false)
                .queryParam("addWinePairing", false)
                .log().ifValidationFails()
                .when()
                .get("recipes/716429/information")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @Test(description = "Test Recipe Similar")
    public void testRecipeSimilar() {
        given().queryParam("apiKey", apiKey)
                .queryParam("id", 715538)
                .queryParam("number", 3)
                .log().ifValidationFails()
                .when()
                .get("recipes/715538/similar")
                .then()
                .statusCode(200)
                .extract().response();
    }

    @Test(description = "Taste by ID")
    public void  tasteById(){
        given().queryParam("apiKey", apiKey)
                .queryParam("id", 69095)
                .queryParam("normalize", false)
                .log().ifValidationFails()
                .when()
                .get("recipes/69095/tasteWidget")
                .then()
                .statusCode(200)
                .extract().response();

    }
}
