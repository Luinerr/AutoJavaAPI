package API.Test.User.GetLogsIntoSystem;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

class SettingTest extends InitTest {
    static UserData userData = new UserData(0, "useruseruserGetLogs", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);

    @BeforeClass
    public static void createUser() {
        given()
                .when()
                .body(userData)
                .post("/user");
    }

    @AfterClass
    public static void afterTest() {
        given()
                .when()
                .delete("/user/" + userData.getUsername());

        given()
                .when()
                .get("/user/logout");
    }
}
