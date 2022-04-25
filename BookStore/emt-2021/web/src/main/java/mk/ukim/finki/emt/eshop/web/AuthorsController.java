package mk.ukim.finki.emt.eshop.web;

import mk.ukim.finki.emt.eshop.model.entities.Author;
import mk.ukim.finki.emt.eshop.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAllAuthors(){
        return this.authorService.findAll();
    }
}