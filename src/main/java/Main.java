import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import domain.Employee;
import domain.Project;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setName("Damian");
        employee.setLastName("Ujma");
        employee.setSalary(new BigDecimal(4500.0));

        Employee employee2 = new Employee();
        employee2.setName("Dawid");
        employee2.setLastName("Nowak");
        employee2.setSalary(new BigDecimal(2550.0));

        Project project1 = new Project();
        project1.setName("Microsoft");


        Project project2 = new Project();
        project2.setName("Apple");

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);
        employees.add(employee2);

        project2.setEmployees(employees);
        List<Employee> employees1 = new ArrayList<Employee>();
        employees1.add(employee);

        project1.setEmployees(employees1);
        entityManager.getTransaction().begin();

        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(project2);
        entityManager.persist(project1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
