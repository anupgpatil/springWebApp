package learning.anup.spring5webapp.bootstrap;

import learning.anup.spring5webapp.model.Author;
import learning.anup.spring5webapp.model.Book;
import learning.anup.spring5webapp.model.Publisher;
import learning.anup.spring5webapp.repositories.AuthorRepository;
import learning.anup.spring5webapp.repositories.BookRepository;
import learning.anup.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Publisher 1","Santa Clara Central","Santa Clara","CA","95051");

        publisherRepository.save(publisher1);

        Author auth1 = new Author("Anup","Patil");
        Book book = new Book("Learning Spring 5","12345678");
        book.setPublisher(publisher1);
        auth1.getBooks().add(book);
        book.getAuthors().add(auth1);
        publisher1.getBooks().add(book);

        authorRepository.save(auth1);
        bookRepository.save(book);
        publisherRepository.save(publisher1);

        Author auth2 = new Author("Author 2","LName");
        Book book2 = new Book("Learning Spring 4","4567889");
        auth2.getBooks().add(book2);
        book2.getAuthors().add(auth2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(auth2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println("=====Started in Spring Boot=====");
        System.out.println("No of Books: "+bookRepository.count());
        System.out.println("No of Publishers: "+publisher1.getBooks().size());

    }
}
