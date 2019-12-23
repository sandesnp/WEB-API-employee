package com.sandesh.web_api_employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sandesh.web_api_employee.R;
import com.sandesh.web_api_employee.model.Employee;

import java.util.List;

public class employeeAdapter extends RecyclerView.Adapter<employeeAdapter.EmployeeViewHolder> {

    Context mContent;
    List<Employee> Employeelist;

    public employeeAdapter(Context mContent, List<Employee> employeelist) {
        this.mContent = mContent;
        Employeelist = employeelist;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.employeeview, parent,false);

        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        final Employee employee= Employeelist.get(position);
        holder.employee_name.setText(employee.getEmployee_name());

        holder.employee_salary.setText(Float.toString(employee.getEmployee_salary()));

        holder.employee_age.setText(Integer.toString(employee.getEmployee_age()));

    }

    @Override
    public int getItemCount() {
        return Employeelist.size();
    }


    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private TextView employee_name, employee_salary, employee_age;

        public EmployeeViewHolder(@NonNull View itemView) {

            super(itemView);
            employee_name = itemView.findViewById(R.id.tvemployeename);
            employee_salary=itemView.findViewById(R.id.tvemployeesalary);
            employee_age=itemView.findViewById(R.id.tvemployeeage);

        }
    }


}
