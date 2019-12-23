package com.sandesh.web_api_employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.sandesh.web_api_employee.Views.EmployeeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEmployee;
    private Button showWord;
    private Button searchWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmployee=findViewById(R.id.btnemployee);

        btnEmployee.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnemployee:
                Intent intent1= new Intent(MainActivity.this, EmployeeActivity.class);
                startActivity(intent1);
                break;


        }
    }
}

