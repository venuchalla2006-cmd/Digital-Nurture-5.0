package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    
    public static List<Department> DEPARTMENT_LIST = new ArrayList<>();

    static {
        LOGGER.info("START - Static block loading departments from employee.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<?> rawList = context.getBean("deptList", ArrayList.class);
        for (Object obj : rawList) {
            if (obj instanceof Department) {
                DEPARTMENT_LIST.add((Department) obj);
            }
        }
        LOGGER.debug("DEPARTMENT_LIST loaded: {}", DEPARTMENT_LIST);
        LOGGER.info("END - Static block loading departments");
    }

    public List<Department> getAllDepartments() {
        LOGGER.info("START - getAllDepartments");
        LOGGER.info("END - getAllDepartments");
        return DEPARTMENT_LIST;
    }
}
