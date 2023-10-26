package API.Test.User.Delete;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.After;
import org.junit.Before;

import static io.restassured.RestAssured.given;

class SettingTests extends InitTest {

    UserData userData = new UserData(0, "useruseruser", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);

    @Before
    public void addUser() {
        given()
                .when()
                .body(userData)
                .post("/user");
    }

    @After
    public void deleteUser() {
        given()
                .when()
                .delete("/user/" + userData.getUsername());
    }

}
