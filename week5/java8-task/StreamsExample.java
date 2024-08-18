package task;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamsExample {

    public static void main(final String[] args) {

        List<Author> authors = Library.getAuthors();
        
        banner("Authors information");

        // TODO With functional interfaces declared
        System.out.println("using functional interface ");
        Consumer<List<Author>> printer = authors1 -> authors1.forEach(System.out::println);
        printer.accept(authors);

        // TODO With functional interfaces used directly
        System.out.println("using functional interfaces used directly ");
        authors.forEach(System.out::println);

        banner("Active authors");

        // TODO With functional interfaces declared
        System.out.println("using functional interface ");
        Predicate<Author> isActiveAuthor = author -> author.active;
        Function<List<Author> , List<Author>> activeAuthor = authors1 ->
                authors1.stream()
                        .filter(isActiveAuthor)
                        .toList();
        System.out.println(activeAuthor.apply(authors));

        // TODO With functional interfaces used directly
        System.out.println("using functional interfaces used directly ");
        List<Author> list = authors.stream()
                .filter(author -> author.active).toList();
        System.out.println(list);

        banner("Active books for all authors");

        // TODO With functional interfaces declared
        System.out.println("using functional interface ");
        Function<List<Author> , List<Book>> activeBooks = authors1 ->
                authors1.stream()
                        .flatMap(author -> author.books.stream())
                        .filter(book -> book.published)
                        .toList();
        System.out.println(activeBooks.apply(authors));

        // TODO With functional interfaces used directly
        System.out.println("using functional interfaces used directly ");
        List<Book> activeBooks1 = authors.stream()
                .flatMap(author -> author.books.stream())
                .filter(book -> book.published)
                .toList();
        System.out.println(activeBooks1);

        banner("Average price for all books in the library");
        
        // TODO With functional interfaces declared
        System.out.println("using functional interface ");
        Function<List<Author> , Double> averageOfBooks = authors1 ->
                authors1.stream()
                        .flatMap(author -> author.books.stream())
                        .mapToDouble(book -> book.price)
                        .average()
                        .orElse(0);
        System.out.println(averageOfBooks.apply(authors));

        // TODO With functional interfaces used directly
        System.out.println("using functional interfaces used directly ");
        double average = authors.stream()
                        .flatMap(author -> author.books.stream())
                        .mapToDouble(book -> book.price)
                        .average()
                        .orElse(0);
        System.out.println(average);

        banner("Active authors that have at least one published book");
        // TODO With functional interfaces declared
        System.out.println("using functional interface ");
        Predicate<List<Book>> isBookPublished = books -> books.stream().anyMatch(Book::isPublished);
        Consumer<List<Author>> activeAuthors = authors1 ->
                authors1.stream()
                        .filter(author -> author.active && isBookPublished.test(author.getBooks()))
                        .forEach(System.out::println);
        activeAuthors.accept(authors);

        // TODO With functional interfaces used directly
        System.out.println("using functional interfaces used directly ");
        authors.stream()
                .filter(author -> author.active && isBookPublished.test(author.getBooks()))
                .forEach(System.out::println);
    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }
}


class Library {
    public static List<Author> getAuthors() {
        return Arrays.asList(
            new Author("Author A", true, Arrays.asList(
                new Book("A1", 100, true),
                new Book("A2", 200, true),
                new Book("A3", 220, true))),
            new Author("Author B", true, Arrays.asList(
                new Book("B1", 80, true),
                new Book("B2", 80, false),
                new Book("B3", 190, true),
                new Book("B4", 210, true))),
            new Author("Author C", true, Arrays.asList(
                new Book("C1", 110, true),
                new Book("C2", 120, false),
                new Book("C3", 130, true))),
            new Author("Author D", false, Arrays.asList(
                new Book("D1", 200, true),
                new Book("D2", 300, false))),
            new Author("Author X", true, Collections.emptyList()));
    }
}

class Author {
    String name;
    boolean active;
    List<Book> books;

    Author(String name, boolean active, List<Book> books) {
        this.name = name;
        this.active = active;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return name + "\t| " + (active ? "Active" : "Inactive");
    }
}

class Book {
    String name;
    int price;
    boolean published;

    Book(String name, int price, boolean published) {
        this.name = name;
        this.price = price;
        this.published = published;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return name + "\t| " + "\t| $" + price + "\t| " + (published ? "Published" : "Unpublished");
    }
}
