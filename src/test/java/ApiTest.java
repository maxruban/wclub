import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void testWineProduct() {
        RestAssured.baseURI = "localhost:9999/club";
        Response response = given()
//                .log().all()
//                .queryParam("user_name", "john.johnson@email.com")
//                .queryParam("password", "password")

//                .body(p)
////                .header(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8)
                .when().get("/user/1")
                .then()
                .assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

    }

    @Test
    public void testWineProduct2() {
        RestAssured.baseURI = "localhost:9999/club";
        RequestSpecification when = given()
                .log().all()
                .queryParam("user_name", "john.johnson@email.com")
                .queryParam("password", "password")

//                .body(p)
////                .header(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8)
                .when();
        Response response = when
                .get("/")
                .then()
                .assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

    }


}
