package com.jemorriswebdesigns.spring6webapp.bootstrap;

import com.jemorriswebdesigns.spring6webapp.domain.Author;
import com.jemorriswebdesigns.spring6webapp.domain.Book;
import com.jemorriswebdesigns.spring6webapp.domain.Publisher;
import com.jemorriswebdesigns.spring6webapp.repositories.AuthorRepository;
import com.jemorriswebdesigns.spring6webapp.repositories.BookRepository;
import com.jemorriswebdesigns.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Morris");

        Book www = new Book();
        www.setTitle("What Women Want");
        www.setIsbn("123456");



        Author johnSaved = authorRepository.save(john);

        Book wwwSaved = bookRepository.save(www);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("My new publisher");
        publisher.setAddress("123 Any street");
        publisher.setCity("Lincoln");
        publisher.setState("Nebrasca");
        Publisher savedPublisher = publisherRepository.save(publisher);
        wwwSaved.setPublisher(savedPublisher);
        bookRepository.save(wwwSaved);

        johnSaved.getBooks().add(wwwSaved);
        authorRepository.save(johnSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
