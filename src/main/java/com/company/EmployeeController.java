package com.company;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    private static final List<Employee> employees= Arrays.asList(
            new Employee(1, "Naresh"),
            new Employee(2, "Suresh"),
            new Employee(3, "Ramesh")
            );

    @GetMapping(path = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id)
    {
        return  employees.stream()
                .filter(employee -> new Integer(id).equals(employee.getId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Employee "+id+" does not exist") );
    }

}
