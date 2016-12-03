package com;

import com.entity.Employee;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Stepan on 03.12.2016.
 */
public class Main {

    public static void main(String[] args) {
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("initentitymanager");
       SessionFactory sessionFactory = (SessionFactory)factory;

       EntityManager entityManager = sessionFactory.createEntityManager();

       entityManager.getTransaction().begin();
       List<Employee> employees = entityManager
               .createQuery("from Employee where name = :name",Employee.class)
               .setParameter("name","Ivan3")
               .getResultList();
       employees.forEach(employee -> {
          System.out.println(employee);
       });
       entityManager.getTransaction().commit();

       entityManager.close();
       sessionFactory.close();
    }

}
