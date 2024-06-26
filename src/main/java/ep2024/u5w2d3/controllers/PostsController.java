package ep2024.u5w2d3.controllers;

import ep2024.u5w2d3.entities.BlogPost;
import ep2024.u5w2d3.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    //GET all http://localhost:3001/posts
    @GetMapping
    private List<BlogPost> getAllPosts() {
        return this.postsService.getPosts();
    }

    //POST http://localhost:3001/posts +body
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost save(@RequestBody BlogPost body) {
        return this.postsService.save(body);
    }

    //GET one http://localhost:3001/posts/:id
    @GetMapping("/{id}")
    private BlogPost findPostById(@PathVariable int id) {
        return this.postsService.findByID(id);
    }

    //PUT http://localhost:3001/posts/:id + body
    @PutMapping("/{id}")
    private BlogPost findPostByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return this.postsService.findByIdAndUpdate(id, body);
    }

    //DELETE http://localhost:3001/posts/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findPostByIdAndDelete(@PathVariable int id) {
        this.postsService.findByIdAndDelete(id);
    }
}
