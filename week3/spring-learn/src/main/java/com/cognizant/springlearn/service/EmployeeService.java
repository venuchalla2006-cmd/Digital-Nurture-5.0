package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        LOGGER.info("START - getAllEmployees");
        List<Employee> result = employeeDao.getAllEmployees();
        LOGGER.info("END - getAllEmployees");
        return result;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START - updateEmployee in Service");
        employeeDao.updateEmployee(employee);
        LOGGER.info("END - updateEmployee in Service");
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        LOGGER.info("START - deleteEmployee in Service");
        employeeDao.deleteEmployee(id);
        LOGGER.info("END - deleteEmployee in Service");
    }
}
