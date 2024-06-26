package ep2024.u5w2d3.services;

import ep2024.u5w2d3.entities.BlogPost;
import ep2024.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class PostsService {
    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> getPosts() {
        return this.posts;
    }

    public BlogPost save(BlogPost body) {
        Random random = new Random();
        body.setId((random.nextInt(10000, 99999)));
        this.posts.add(body);
        return body;
    }

    public BlogPost findByID(int id) {
        BlogPost found = null;
        for (BlogPost post : this.posts) {
            if (post.getId() == id) found = post;
        }
        if (found != null) {
            return found;
        } else {
            throw new NotFoundException(id);
        }
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updatedPost) {
        BlogPost found = null;
        for (BlogPost post : this.posts) {
            if (post.getId() == id) {
                found = post;
                found.setGenre((updatedPost.getGenre()));
                found.setTitle((updatedPost.getTitle()));
                found.setCover((updatedPost.getCover()));
                found.setContent((updatedPost.getContent()));
                found.setReadingTime((updatedPost.getReadingTime()));
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new NotFoundException(id);
        }
    }

    public void findByIdAndDelete(int id) {
        Iterator<BlogPost> iterator = this.posts.iterator();

        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
