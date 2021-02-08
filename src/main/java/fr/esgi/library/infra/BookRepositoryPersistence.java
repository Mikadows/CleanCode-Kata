package fr.esgi.library.infra;

import fr.esgi.library.model.Book;
import fr.esgi.library.model.IBookRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryPersistence implements IBookRepository {

    @Override
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();

        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream("books.repo"))) {

            books = (List<Book>) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return books;    }

    @Override
    public void writeBooks(List<Book> books) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("books.repo"))) {

            oos.writeObject(books);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
