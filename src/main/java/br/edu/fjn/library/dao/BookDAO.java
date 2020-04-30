package br.edu.fjn.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fjn.library.model.Book;

/*
* DAO - Data Access Object
*/
public class BookDAO {

    public EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit-fjn");

    public void save(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public Book findById(Integer code) {
        EntityManager em = factory.createEntityManager();
        Book b = em.find(Book.class, code);
        em.close();
        return b;
    }

    public void update(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * so pra vocês conhecerem a detecção automatica de estado
     */
    public void autoUpdate() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Book b = em.find(Book.class, 1);
        b.setName("Java In Action");
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Book book) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Book b = em.find(Book.class, book.getCode());
        em.remove(b);
        em.getTransaction().commit();
        em.close();
    }

}