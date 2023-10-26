package API.Test.User.Delete;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestUserDelete extends SettingTests{

    @Test
    public void deleteUser_DeletingUser() {
        given()
                .when()
                .delete("/user/" + userData.getUsername());
        int status = given()
                .when()
                .get("/user/" + userData.getUsername())
                .then()
                .extract().statusCode();
        Assert.assertEquals(404, status);
    }

    @Test
    public void deleteInvalidUsernameRu_400() {
        int status = given()
                .when()
                .delete("/user/абвгдеж")
                .then()
                .extract().statusCode();
        Assert.assertEquals(400, status);
    }

    @Test
    public void deleteInvalidUsernameSpec_400() {
        int status = given()
                .when()
                .delete("/user/@#$%")
                .then()
                .extract().statusCode();
        Assert.assertEquals(400, status);
    }

    @Test
    public void deleteNonExistentUser_404() {
        int status = given()
                .when()
                .delete("/user/aaaaasdfasdfasdf123dsafasdsaf")
                .then()
                .extract().statusCode();
        Assert.assertEquals(404, status);
    }
}
