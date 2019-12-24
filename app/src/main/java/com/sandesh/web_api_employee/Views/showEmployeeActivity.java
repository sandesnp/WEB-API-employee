package com.sandesh.web_api_employee.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sandesh.web_api_employee.R;
import com.sandesh.web_api_employee.adapter.employeeAdapter;
import com.sandesh.web_api_employee.api.EmployeeAPI;
import com.sandesh.web_api_employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class showEmployeeActivity extends AppCompatActivity {

private final static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

private EditText etsearch;
private Button btnsearch;

private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        etsearch=findViewById(R.id.etsearch);

        btnsearch=findViewById(R.id.btnsearch);
        recyclerView=findViewById(R.id.recyclerViewSingle);


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final EmployeeAPI employeeAPI= retrofit.create(EmployeeAPI.class);

        Call<Employee> listCall= employeeAPI.getEmployeeById(Integer.parseInt(etsearch.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

                Toast.makeText(showEmployeeActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                /////////////// MAKE THIS RECYCLER
                List<Employee> employeeList= new ArrayList<>();
                Employee emp = response.body();

                employeeList.add(emp);
                employeeAdapter employeeAdapter = new employeeAdapter(getBaseContext(), employeeList);
                recyclerView.setAdapter(employeeAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                ////////////////////

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(showEmployeeActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
