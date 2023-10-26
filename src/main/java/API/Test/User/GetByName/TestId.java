package API.Test.User.GetByName;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class TestId extends InitTest {

    @Test
    public void whenRequestGet_thenOk() {
        UserData userData = given()
                .when()
                .get("/user/user1")
                .then().log().all()
                .extract().body().jsonPath().getObject("$", UserData.class);
        Assert.assertEquals(9223372036854758720L, userData.getId());
    }
}