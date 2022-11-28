package home.task.utils.api.calls;

import home.task.utils.api.calls.models.EmployeeModel;
import home.task.utils.api.calls.models.NewEmployeeModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCalls {

    private final Logger LOGGER = LogManager.getLogger(ApiCalls.class);

    /**
     * API Get request to get all employees
     * @return all employees by String
     */
    public String getAllEmployees() {

        LOGGER.info("Get all employee list");
        try {
            return given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("employees")
                    .then()
                    .statusCode(200)
                    .body("status", equalTo("success"))
                    .extract()
                    .response()
                    .asString();

        } catch (Exception e) {
            LOGGER.error(e);
        }

        return null;
    }

    /**
     * API Post request to create a new employee
     * @param newEmployee model json of the new employee
     * @return the ID of the new employee
     */
    public String createNewEmployee(NewEmployeeModel newEmployee) {

        LOGGER.info("Create new employee");

        Response response = null;

        try {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(newEmployee)
                    .when()
                    .post("create")
                    .then()
                    .statusCode(200)
                    .body("status", equalTo("success"))
                    .extract()
                    .response();

        } catch (Exception e) {
            LOGGER.error(e);
        }

        return response.jsonPath().getString("data.id");

    }

    /**
     * API Get request to get one employee by ID
     * @param employeeId the employee ID
     * @return EmployeeModel class with the details of the employee
     */
    public EmployeeModel getEmployeeById(String employeeId) {

        LOGGER.info("Get employee details by id");

        try {
            return given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("employee/{employeeId}", employeeId)
                    .then()
                    .statusCode(200)
                    .body("status", equalTo("success"))
                    .extract()
                    .response().jsonPath().getObject("data", EmployeeModel.class);

        } catch (Exception e) {
            LOGGER.error(e);
        }

        return null;
    }

}
