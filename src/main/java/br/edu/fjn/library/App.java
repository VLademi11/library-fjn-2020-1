package br.edu.fjn.library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fjn.library.dao.BookDAO;
import br.edu.fjn.library.dao.CustomerDAO;
import br.edu.fjn.library.model.Address;
import br.edu.fjn.library.model.Customer;
import br.edu.fjn.library.model.Phone;
import br.edu.fjn.library.model.PhoneType;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        // Customer c = new Customer();
        // c.setName("Ana Silva");
        // c.setCpf("321.123.345-10");
        // c.setEmail("ana@gmail.com");
        // c.setAddress(new Address(null, "R. Santos Doumond", "133"));

        // Phone p1 = new Phone();
        // p1.setNumber("35110987");
        // p1.setType(PhoneType.LANDLINE);

        // Phone p2 = new Phone();
        // p2.setNumber("999088123");
        // p2.setType(PhoneType.CELLPHONE);

        // List<Phone> phones = new ArrayList<>();
        // phones.add(p1);
        // phones.add(p2);

        // c.setPhones(phones);

        // customerDAO.save(c);

        // Customer c = customerDAO.findById(1);
        // System.out.println("Cliente: " + c.getName());
        // System.out.println("Endereço: " + c.getAddress());
        // c.setAddress(new Address(2, "R. Sao Pedro", "15"));
        // customerDAO.update(c);

        // c = customerDAO.findById(1);
        // System.out.println("Cliente: " + c.getName());
        // System.out.println("Endereço: " + c.getAddress().getStreet());

        Customer c = customerDAO.findById(1);
        System.out.println("Cod. Cliente: " + c.getCode());
        System.out.println("Cliente: " + c.getName());
        System.out.println("Endereço: " + c.getAddress().getCode() + " " + c.getAddress().getStreet());
        c.getPhones().forEach(p -> {
            System.out.println(" - Cod. Telefone: " + p.getCode());
            System.out.println(" - Telefone: " + p.getNumber());
            System.out.println(" - Tipo Telefone: " + p.getType());
        });

        customerDAO.factory.close();
        bookDAO.factory.close();
    }
}