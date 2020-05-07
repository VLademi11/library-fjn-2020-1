package br.edu.fjn.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fjn.library.model.Customer;

public class CustomerDAO {

    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit-fjn");

    public void save(Customer customer) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(customer);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Uma falha aconteceu...");
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void update(Customer customer) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(customer);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Uma falha aconteceu...");
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public Customer findById(Integer id) {
        EntityManager em = factory.createEntityManager();
        Customer c = em.find(Customer.class, id);
        em.close();
        return c;
    }

    public void remove(Customer customer) {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            Customer c = manager.find(Customer.class, customer.getCode());
            manager.remove(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Uma falha aconteceu...");
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }

}