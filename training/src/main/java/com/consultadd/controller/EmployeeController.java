package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import com.consultadd.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//  default page
//  @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String home_page(Model model){
        List<Employee> employees = employeeService.getEmployee();
        model.addAttribute("emplist", employees);
        return "index";
    }
//  route to test database and api
    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        List<Employee> employees = employeeService.getEmployee();
        return employees;
    }
//  manual adding api
    @PostMapping("/addEmployee")
    public String setEmployee(@RequestBody Employee employee){
        return employeeService.setEmployee(employee);
    }

//    web route to add employee

    @RequestMapping("/new")
    public String newformforemployee(Model model)
    {
//      empty object
        Employee employee=new Employee();
//      sending empty object for population
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping(value="add")
    public String addEmployee(Employee employee)
    {
        employeeService.setEmployee(employee);
        return "redirect:/";
    }

//    web route to delete employee
    @GetMapping("/delete/{id}")
    public String deleteemp(@PathVariable("id")String id)
    {
        employeeService.deleteEmployee(id);
//        repo.deleteById(id);
        return "redirect:/";
    }
}
