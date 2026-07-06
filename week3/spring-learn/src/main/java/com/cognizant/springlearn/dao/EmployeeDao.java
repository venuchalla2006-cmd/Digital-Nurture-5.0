package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    
    // Static Employee List
    public static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        LOGGER.info("START - Static block loading employee.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<?> rawList = context.getBean("employeeList", ArrayList.class);
        for (Object obj : rawList) {
            if (obj instanceof Employee) {
                EMPLOYEE_LIST.add((Employee) obj);
            }
        }
        LOGGER.debug("EMPLOYEE_LIST loaded: {}", EMPLOYEE_LIST);
        LOGGER.info("END - Static block loading employee.xml");
    }

    public List<Employee> getAllEmployees() {
        LOGGER.info("START - getAllEmployees");
        LOGGER.info("END - getAllEmployees");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START - updateEmployee: {}", employee.getId());
        boolean found = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                found = true;
                LOGGER.debug("Employee updated in DAO: {}", employee);
                break;
            }
        }
        if (!found) {
            LOGGER.error("Employee not found with ID: {}", employee.getId());
            throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getId());
        }
        LOGGER.info("END - updateEmployee");
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        LOGGER.info("START - deleteEmployee: {}", id);
        boolean removed = EMPLOYEE_LIST.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            LOGGER.error("Employee not found to delete with ID: {}", id);
            throw new EmployeeNotFoundException("Employee not found to delete with ID: " + id);
        }
        LOGGER.info("END - deleteEmployee");
    }
}
