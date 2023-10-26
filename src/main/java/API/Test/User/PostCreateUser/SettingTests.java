package API.Test.User.PostCreateUser;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.After;

import static io.restassured.RestAssured.given;

abstract class SettingTests extends InitTest {
    UserData userData = new UserData(0, "useruseruser", "firstName", "lastName",
            "email@email.ru", "password", "1234567890", 0);


    //Delete created user
    @After
    public void afterConditional() {
        given()
                .when()
                .delete("/user/" + userData.getUsername());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
    }
}
