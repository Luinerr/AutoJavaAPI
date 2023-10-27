package API.Core;

import API.Core.Specification.Specifications;
import org.junit.AfterClass;
import org.junit.BeforeClass;

abstract public class InitTest {
    protected static String url = "https://petstore.swagger.io/v2";
    @BeforeClass
    public static void SetUp() {
        Specifications.installSpecification(Specifications.requestSpec(url), Specifications.responseSpecOk200());


    }

}
