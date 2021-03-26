package pl.artimerek.webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.artimerek.webapp.model.Author;
import pl.artimerek.webapp.model.Book;
import pl.artimerek.webapp.model.Publisher;
import pl.artimerek.webapp.repos.AuthorRepository;
import pl.artimerek.webapp.repos.BookRepository;
import pl.artimerek.webapp.repos.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher tolkien = new Publisher("JRR","Tolkien");
        publisherRepository.save(tolkien);


        Author konrad = new Author("Konrad", "Rzepakowski");
        Book idkHowToNameThatBook = new Book("How to name the book", "1999", tolkien);
        konrad.getBooks().add(idkHowToNameThatBook);
        idkHowToNameThatBook.getAuthors().add(konrad);


        authorRepository.save(konrad);
        bookRepository.save(idkHowToNameThatBook);

        Author helloW = new Author("Maciek", "Klanowski");
        Book klan = new Book("Cleaning hands without water", "3513",tolkien);
        helloW.getBooks().add(klan);
        authorRepository.save(helloW);
        bookRepository.save(klan);


    }
}
