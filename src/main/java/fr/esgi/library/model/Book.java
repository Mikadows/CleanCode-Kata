package fr.esgi.library.model;

public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static Book of(String title, String author){
        return new Book(title, author);
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
