package com.consultadd.services;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();

    }

    public String setEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            return "ID Exists";
        }else{
            employeeRepository.save(employee);
        }
        return "saved employee data";
    }
}
