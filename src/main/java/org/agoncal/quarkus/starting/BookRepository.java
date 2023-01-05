package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) Jumia.
 */
@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    private String genre;

    public List<Book> getAllBooks() {

        return List.of(
                new Book(1, "effective java", "Joshoa", 1980, genre),
                new Book(2, "Head first", "No one", 1985, genre)
        );
    }

    public Optional<Book> getBook(@PathParam("id") int id) {

        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
