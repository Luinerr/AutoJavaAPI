package API.Test.User.GetLogsIntoSystem;


import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestUserGetLogs extends SettingTest {

    @Test
    public void loginUser_200() {
        int status = given()
                .when()
                .queryParam("username", userData.getUsername())
                .queryParam("password", userData.getPassword())
                .get("/user/login")
                .then()
                .extract().statusCode();
        Assert.assertEquals(200, status);
    }



    @Test
    public void loginUserInvalidPass_400() {
        int status = given()
                .when()
                .queryParam("username", userData.getUsername())
                .queryParam("password", "asdfasdfasdfasdf")
                .get("/user/login")
                .then()
                .extract().statusCode();
        Assert.assertEquals(400, status);
    }

    @Test
    public void loginUserInvalidLogin_400() {
        int status = given()
                .when()
                .queryParam("username", "dsafsdfzvxcvcbxzgedafcxvzxvafg4wescf")
                .queryParam("password", userData.getPassword())
                .get("/user/login")
                .then()
                .extract().statusCode();
        Assert.assertEquals(400, status);
    }

}
