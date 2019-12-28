package com.sandesh.web_api_employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.sandesh.web_api_employee.Views.EmployeeActivity;
import com.sandesh.web_api_employee.Views.EmployeeRegisterActivity;
import com.sandesh.web_api_employee.Views.showEmployeeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnEmployee;
    private Button btnRegister;
    private Button btnsearchEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmployee = findViewById(R.id.btnemployee);
        btnsearchEmployee = findViewById(R.id.btnsearchemployee);
        btnRegister=findViewById(R.id.btngoregister);


        btnEmployee.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnsearchEmployee.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnemployee:
                Intent intent1 = new Intent(MainActivity.this, EmployeeActivity.class);
                startActivity(intent1);
                break;

            case R.id.btnsearchemployee:
                Intent intent2 = new Intent(MainActivity.this, showEmployeeActivity.class);
                startActivity(intent2);
                break;

            case R.id.btngoregister:
                Intent intent03 = new Intent(MainActivity.this, EmployeeRegisterActivity.class);
                startActivity(intent03);
                break;

        }
    }
}

