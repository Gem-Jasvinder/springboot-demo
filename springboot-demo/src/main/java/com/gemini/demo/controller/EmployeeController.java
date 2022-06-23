package com.springrestexample.demo.controller;


import com.springrestexample.demo.entities.Employee;
import com.springrestexample.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Value("${my.first.name}")
    private String myFirstName;

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String welcome(){
        return "Welcome to Rest Appl." + "  "+ myFirstName;
    }



    @GetMapping("/User/AllEmployee")
    public ResponseEntity getEmployeeUser() {
//        try {
//            List<Employee> list = employeeService.getEmployeeUser();
//            if (list.size() <= 0) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List is Empty");
//
//            }
//            return ResponseEntity.of(Optional.of(list));
//        }catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return employeeService.geytEmplyeeUser();
        List<Employee> l = employeeService.getEmployeeUser();
        try {
            if (l.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty List");
            }
            return ResponseEntity.of(Optional.of(l));
        } catch (Exception e) {
//                logger.info("Oops!",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }

    }

    @PostMapping("/User/AddEmployee")
    public ResponseEntity addEmployeeUser(@RequestBody Employee employee) {
        Employee employee1 = null;
        try {
//            try{
//                Integer.parseInt(userMaster.getId());
//            }catch(Exception e){
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id must be Integer Type");
//            }
            employee1 = employeeService.addEmployeeUser(employee);
            if(employee1 == null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something wrong is datatype or query");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee is added successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

