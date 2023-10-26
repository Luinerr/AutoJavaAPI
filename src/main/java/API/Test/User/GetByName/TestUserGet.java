package API.Test.User.GetByName;

import API.Pojo.UserData;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class TestUserGet extends SettingTest {

    @Test
    public void getUserByName_200() {
        int status = given()
                .when()
                .get("/user/" + userData.getUsername())
                .then()
                .extract().statusCode();
        Assert.assertEquals(200, status);
    }

    @Test
    public void getUserByName_Equal() {
        UserData userDataActual = given()
                .when()
                .get("/user/" + userData.getUsername())
                .then()
                .extract().body().jsonPath().getObject("$", UserData.class);

        assertThat(userData).isEqualToIgnoringGivenFields(userDataActual, "id");
    }
}