package com.sandesh.web_api_employee.api;

import com.sandesh.web_api_employee.model.Employee;
import com.sandesh.web_api_employee.model.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface EmployeeAPI {

    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    @GET("employee/{empID}")
    Call<Employee> getEmployeeById(@Path("empID")int empId);

    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);
}
