package ma.ensa.employeemanager.repository;

import ma.ensa.employeemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
