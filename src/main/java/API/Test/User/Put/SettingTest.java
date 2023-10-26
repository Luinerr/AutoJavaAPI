package API.Test.User.Put;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;

abstract class SettingTest extends InitTest {

    UserData userData = new UserData(0, "useruseruser", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);

    static UserData userDataBefore = new UserData(0, "useruseruser", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);
    @BeforeClass
    public static void addUser() {
        given()
                .when()
                .body(userDataBefore)
                .post("/user");
    }

    @After
    public void endTest() {
        given()
                .when()
                .body(userDataBefore)
                .put("/user/" + userData.getUsername());
        userData = userDataBefore;
    }

    @AfterClass
    public static void tearDown() {
        given()
                .when()
                .delete("/user/" + userDataBefore.getUsername());
    }



}
