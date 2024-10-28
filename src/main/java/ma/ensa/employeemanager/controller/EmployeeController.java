package ma.ensa.employeemanager.controller;

import ma.ensa.employeemanager.service.EmployeeService;
import ma.ensa.employeemanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create a new employee
    @PostMapping
    public Employee createemployee(@RequestBody Employee employee) {
        return employeeService.createemployee(employee);
    }

    // Retrieve a employee by ID
    @GetMapping("/{id}")
    public Optional<Employee> getemployeeById(@PathVariable Long id) {
        return employeeService.getemployeeById(id);
    }

    // Retrieve all employees
    @GetMapping
    public List<Employee> getAllemployees() {
        return employeeService.getAllemployees();
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public Employee updateemployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateemployee(id, employee);
    }

    // Delete a employee by ID
    @DeleteMapping("/{id}")
    public void deleteemployee(@PathVariable Long id) {
        employeeService.deleteemployee(id);
    }
}
