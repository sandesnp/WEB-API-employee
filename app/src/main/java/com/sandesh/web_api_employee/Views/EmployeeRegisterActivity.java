package com.sandesh.web_api_employee.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sandesh.web_api_employee.R;
import com.sandesh.web_api_employee.api.EmployeeAPI;
import com.sandesh.web_api_employee.model.EmployeeCUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EmployeeRegisterActivity extends AppCompatActivity {


    private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    private EditText etname, etsalary, etage;
    private Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_register);

        etname = findViewById(R.id.etnamee);
        etsalary = findViewById(R.id.etsalary);
        etage = findViewById(R.id.etage);

        btnregister = findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });


    }


    private void Register() {

        String name = etname.getText().toString();
        Float salary = Float.parseFloat(etsalary.getText().toString());
        int age = Integer.parseInt(etage.getText().toString());

        EmployeeCUD employeeCUD = new EmployeeCUD(name, salary, age);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        Call<Void> voidCall = employeeAPI.registerEmployee(employeeCUD);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(EmployeeRegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(EmployeeRegisterActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
