package br.edu.fjn.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fjn.library.dao.BookDAO;
import br.edu.fjn.library.dao.CustomerDAO;
import br.edu.fjn.library.model.Address;
import br.edu.fjn.library.model.Customer;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        // Customer c = new Customer();
        // c.setCode(2);
        // c.setName("Maria Silva");
        // c.setCpf("321.123.345-12");
        // c.setEmail("maria@gmail.com");
        // c.setAddress(new Address(1, "R. Sao Paulo", "34B"));
        // customerDAO.save(c);

        Customer c = customerDAO.findById(1);
        System.out.println("Cliente: " + c.getName());
        System.out.println("Endereço: " + c.getAddress());
        c.setAddress(new Address(2, "R. Sao Pedro", "15"));
        customerDAO.update(c);

        c = customerDAO.findById(1);
        System.out.println("Cliente: " + c.getName());
        System.out.println("Endereço: " + c.getAddress().getStreet());

        c = customerDAO.findById(2);
        System.out.println("Cliente: " + c.getName());
        System.out.println("Endereço: " + c.getAddress().getStreet());

        customerDAO.factory.close();
        bookDAO.factory.close();
    }
}