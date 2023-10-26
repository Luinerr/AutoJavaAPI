package API.Test.User.PostList;

import API.Pojo.UserData;
import io.restassured.path.json.JsonPath;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPostArrayPositive extends BeforeTest {

    @Test
    public void add5Users_200() {
        JsonPath status = given()
                .body(userDataList)
                .post("/user/createWithList")
                .then()
                .extract().jsonPath();
        assertThat(status.getInt("code")).isEqualTo(200);
    }


    @Test
    public void add1Users_allDataCorrect() {
        given()
                .body(userDataList1)
                .post("/user/createWithList");

        List<UserData> userDataListActual = new ArrayList<>();
        userDataList1.stream()
                .forEach(userData -> {
                    UserData userData1 = given()
                            .get("/user/" + userData.getUsername())
                            .then()
                            .extract().body().jsonPath().getObject("$", UserData.class);
                    userDataListActual.add(userData1);
                });


        for(int i = 0; i < userDataListActual.size(); i++) {
            assertThat(userDataList1.get(i)).isEqualToIgnoringGivenFields(userDataListActual.get(i), "id");
        }
    }

    @Test
    public void add2Users_allDataCorrect() {
        given()
                .body(userDataList2)
                .post("/user/createWithList");

        List<UserData> userDataListActual = new ArrayList<>();
        userDataList2.stream()
                .forEach(userData -> {
                    UserData userData1 = given()
                            .get("/user/" + userData.getUsername())
                            .then()
                            .extract().body().jsonPath().getObject("$", UserData.class);
                    userDataListActual.add(userData1);
                });


        for(int i = 0; i < userDataListActual.size(); i++) {
            assertThat(userDataList2.get(i)).isEqualToIgnoringGivenFields(userDataListActual.get(i), "id");
        }
    }

    @Test
    public void add5Users_allDataCorrect() {
        given()
                .body(userDataList)
                .post("/user/createWithList");

        List<UserData> userDataListActual = new ArrayList<>();
        userDataList.stream()
                .forEach(userData -> {
                    UserData userData1 = given()
                            .get("/user/" + userData.getUsername())
                            .then()
                            .extract().body().jsonPath().getObject("$", UserData.class);
                    userDataListActual.add(userData1);
                });


        for(int i = 0; i < userDataListActual.size(); i++) {
            assertThat(userDataList.get(i)).isEqualToIgnoringGivenFields(userDataListActual.get(i), "id");
        }
    }

    @Test
    public void add10Users_allDataCorrect() {
        given()
                .body(userDataList10)
                .post("/user/createWithList");

        List<UserData> userDataListActual = new ArrayList<>();
        userDataList10.stream()
                .forEach(userData -> {
                    UserData userData1 = given()
                            .get("/user/" + userData.getUsername())
                            .then()
                            .extract().body().jsonPath().getObject("$", UserData.class);
                    userDataListActual.add(userData1);
                });


        for(int i = 0; i < userDataListActual.size(); i++) {
            assertThat(userDataList10.get(i)).isEqualToIgnoringGivenFields(userDataListActual.get(i), "id");
        }
    }


}
