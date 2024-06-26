package ep2024.u5w2d3.controllers;

import ep2024.u5w2d3.entities.Author;
import ep2024.u5w2d3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    //GET all http://localhost:3001/authors
    @GetMapping
    private List<Author> getAllAuthors() {
        return this.authorService.getAuthors();
    }

    //POST http://localhost:3001/authors +body
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author save(@RequestBody Author body) {
        return this.authorService.save(body);
    }

    //GET one http://localhost:3001/authors/:id
    @GetMapping("/{id}")
    private Author findAuthorById(@PathVariable int id) {
        return this.authorService.findByID(id);
    }

    //PUT http://localhost:3001/authors/:id + body
    @PutMapping("/{id}")
    private Author findAuthorByIdAndUpdate(@PathVariable int id, @RequestBody Author body) {
        return this.authorService.findByIdAndUpdate(id, body);
    }

    //DELETE http://localhost:3001/authors/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable int id) {
        this.authorService.findByIdAndDelete(id);
    }
}
