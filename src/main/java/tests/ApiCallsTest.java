package tests;

import home.task.utils.BaseUtils;
import home.task.utils.RetryAnalyzer;
import home.task.utils.api.calls.models.EmployeeModel;
import home.task.utils.api.calls.models.NewEmployeeModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static tests.TestsConstant.*;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

// Listener for the extent properties
@Listeners({ExtentITestListenerClassAdapter.class})
public class ApiCallsTest extends BaseUtils {

    // new employee ID
    String newEmpId;

    /**
     * This test checks by API to get all employees
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testGetAllEmployees() {
        apiCalls.getAllEmployees();
    }

    /**
     * This test checks by API to create a new employee
     */
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void testCreateNewEmployee() {
        NewEmployeeModel newEmployeeModel = new NewEmployeeModel(NEW_EMPLOYEE_NAME, NEW_EMPLOYEE_SALARY, NEW_EMPLOYEE_AGE);
        newEmpId = apiCalls.createNewEmployee(newEmployeeModel);
    }

    /**
     * This test checks by API to get one employee by ID
     */
    @Test(dependsOnMethods = "testCreateNewEmployee", retryAnalyzer = RetryAnalyzer.class)
    public void testGetNewEmployeeDetails() {
        EmployeeModel employeeModel = apiCalls.getEmployeeById(newEmpId);
    }

}
