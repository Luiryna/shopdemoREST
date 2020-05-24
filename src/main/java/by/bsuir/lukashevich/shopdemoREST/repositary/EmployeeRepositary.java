package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositary extends JpaRepository<Employee, Long> {
}
