package API.Test.User.GetByName;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

public class SettingTest extends InitTest {
    static UserData userData = new UserData(0, "useruseruser123", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);

    @BeforeClass
    public static void addUser() {
        given()
                .when()
                .body(userData)
                .post("/user");
    }

    @AfterClass
    public static void deleteUser() {
        given()
                .when()
                .delete("/user/" + userData.getUsername());
    }
}
