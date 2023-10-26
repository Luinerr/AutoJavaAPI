package API.Test.User.PostCreateUser;

import API.Pojo.UserData;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPostPositive extends BeforeTest {

    @Test
    public void post_Response200() {
       ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void post_equalityData() {
        given()
                .when()
                .body(userData)
                .post("/user");

        UserData userDataActual = given()
                .when()
                .get("/user/" + userData.getUsername())
                .then()
                .extract().body().jsonPath().getObject("$", UserData.class);

        assertThat(userData).isEqualToIgnoringGivenFields(userDataActual, "id");
    }
    @Test
    public void testNameUserWithHyphen_200() {
        userData.setUsername("abcd-abcd");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void testNameUserWithApostrophe_200() {
        userData.setUsername("abcd`abcd");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void testNameUserWithWhitespace_200() {
        userData.setUsername("abcd abcd");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void testNameUserWithNumber_200() {
        userData.setUsername("abcd123abcd");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void testNameUserWithSpec_200() {
        userData.setUsername("abcd@#$%abcd");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

    @Test
    public void testNameUserWith50Char_200() {
        userData.setUsername("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        ResponseBody responseBody = given()
                .when()
                .body(userData)
                .post("/user")
                .then()
                .extract().body().jsonPath().getObject("$", ResponseBody.class);

        Assert.assertTrue(responseBody.getCode().equals(200));
    }

}
