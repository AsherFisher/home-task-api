package home.task.utils.api.calls.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewEmployeeModel {


    /**
     * New Employee Model
     */
    @JsonProperty("name")
    private String name;
    @JsonProperty("salary")
    private String salary;
    @JsonProperty("age")
    private String age;


    public NewEmployeeModel(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("salary")
    public String getSalary() {
        return salary;
    }

    @JsonProperty("salary")
    public void setSalary(String salary) {
        this.salary = salary;
    }

    @JsonProperty("age")
    public String getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }
}