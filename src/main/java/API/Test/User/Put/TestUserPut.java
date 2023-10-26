package API.Test.User.Put;

import API.Pojo.UserData;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Bug put создает нового юзера каждый раз
 */
public class TestUserPut extends SettingTest {

    @Test
    public void updateUserNotCreateNewUser() {
        String userName = userData.getUsername();
        userData.setUsername("namefirstnamefirst");
        given()
                .when()
                .body(userData)
                .put("/user/" + userName);

        Assert.assertEquals(404, given()
                .when()
                .get("/user/" + userName)
                .then()
                .extract().statusCode());
    }


    @Test
    public void updateUserName() {
        String userName = userData.getUsername();
        userData.setUsername("namenamename");
        given()
                .when()
                .body(userData)
                .put("/user/" + userName);

        UserData userDataActual = given()
                .when()
                .get("/user/" + userData.getUsername())
                .then()
                .extract().body().jsonPath().getObject("$", UserData.class);

        assertThat(userData).isEqualToIgnoringGivenFields(userDataActual, "id");
    }
}
