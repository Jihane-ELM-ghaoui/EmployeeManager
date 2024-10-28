package ma.ensa.employeemanager.service;

import ma.ensa.employeemanager.entity.Employee;
import ma.ensa.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MessageSource messageSource;

    // Create a new employee
    public Employee createemployee(Employee employee, Locale locale) {
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new RuntimeException(messageSource.getMessage("email.already.use", null, locale));
        }
        Employee savedEmployee = employeeRepository.save(employee);
        System.out.println(messageSource.getMessage("employee.add.success", null, locale));
        return savedEmployee;
    }

    // Retrieve an employee by ID
    public Employee getemployeeById(long id, Locale locale) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException(messageSource.getMessage("employee.notfound", null, locale))
        );
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