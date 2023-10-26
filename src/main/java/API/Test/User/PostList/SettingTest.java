package API.Test.User.PostList;

import API.Core.InitTest;
import API.Pojo.UserData;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

abstract class SettingTest extends InitTest {

    List<UserData> userDataList1 = new ArrayList<>(Arrays.asList(
            new UserData(0, "useruseruser1", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0)
            ));
    List<UserData> userDataList2 = new ArrayList<>(Arrays.asList(
            new UserData(0, "useruseruser1", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser2", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0)
            ));

    List<UserData> userDataList = new ArrayList<>(Arrays.asList(
            new UserData(0, "useruseruser1", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser2", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser3", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser4", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser5", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0)
    ));

    List<UserData> userDataList10 = new ArrayList<>(Arrays.asList(
            new UserData(0, "useruseruser1", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser2", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser3", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser4", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser5", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser6", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser7", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser8", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser9", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0),
            new UserData(0, "useruseruser10", "firstName", "lastName",
                    "email@email.ru", "password", "1234567890", 0)
    ));

    //Delete created user
    @After
    public void afterConditional() {
        userDataList10.stream()
                .forEach(userData ->
                        given()
                                .when()
                                .delete("/user/" + userData.getUsername())
                                .then()
                                .log().all());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }

    private void deleteUsers(List<UserData> users) {
        users.stream()
                .forEach(userData -> given()
                        .when()
                        .delete("/user/" + userData.getUsername())
                );
    }
}
