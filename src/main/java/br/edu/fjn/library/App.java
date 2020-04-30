package br.edu.fjn.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.fjn.library.dao.BookDAO;
import br.edu.fjn.library.model.Book;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAO();
        // Book book = new Book(2, "JPA in Action");
        // bookDAO.save(book);
        // System.out.println(book.getName() + " salvo com sucesso!");

        Book myBook = bookDAO.findById(1);

        System.out.println(myBook.getName());

        // myBook.setName("JPA In Action 2 Ed.");

        // bookDAO.update(myBook);
        // System.out.println(myBook.getName() + " atualizado com sucesso :)");

        //bookDAO.remove(myBook);
        //System.out.println(myBook.getName() + " excluído com muito sucesso!");

        //bookDAO.autoUpdate();

        // temporario
        bookDAO.factory.close();
    }
}
