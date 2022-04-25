package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.dto.BookDto;
import mk.ukim.finki.emt.eshop.model.entities.Author;
import mk.ukim.finki.emt.eshop.model.entities.Book;
import mk.ukim.finki.emt.eshop.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.eshop.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.eshop.repository.AuthorRepository;
import mk.ukim.finki.emt.eshop.repository.BookRepository;
import mk.ukim.finki.emt.eshop.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(bookRepository.findById(id)).get();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(AuthorNotFoundException::new);
        Book newBook = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(newBook));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(AuthorNotFoundException::new);

        book.setName(bookDto.getName());
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        Integer quantity = book.getAvailableCopies();

        book.setAvailableCopies(quantity-1);
        this.bookRepository.save(book);
    }
}
