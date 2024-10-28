package ma.ensa.employeemanager.service;

import ma.ensa.employeemanager.entity.Employee;
import ma.ensa.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new employee
    public Employee createemployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Retrieve an employee by ID
    public Optional<Employee> getemployeeById(long id) {
        return employeeRepository.findById(id);
    }

    // Retrieve all employees
    public List<Employee> getAllemployees() {
        return employeeRepository.findAll();
    }

    // Update an existing employee
    public Employee updateemployee(long id, Employee updatedemployee) {
        Employee existingemployee = employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("employee not found with id: " + id)
        );

        existingemployee.setFirstName(updatedemployee.getFirstName());
        existingemployee.setLastName(updatedemployee.getLastName());
        existingemployee.setBirthday(updatedemployee.getBirthday());
        existingemployee.setEmail(updatedemployee.getEmail());
        existingemployee.setPhone(updatedemployee.getPhone());
        existingemployee.setAddress(updatedemployee.getAddress());
        existingemployee.setDepartement(updatedemployee.getDepartement());
        existingemployee.setPoste(updatedemployee.getPoste());

        return employeeRepository.save(existingemployee);
    }

    // Delete an employee by ID
    public void deleteemployee(long id) {
        employeeRepository.deleteById(id);
    }
}