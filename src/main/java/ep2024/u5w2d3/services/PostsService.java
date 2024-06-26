package ep2024.u5w2d3.services;

import ep2024.u5w2d3.entities.BlogPost;
import ep2024.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostsService {
    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> getPosts() {
        return this.posts;
    }

    public BlogPost save(BlogPost body) {
        this.posts.add(body);
        return body;
    }

    public BlogPost findByID(UUID id) {
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

    public BlogPost findByIdAndUpdate(UUID id, BlogPost updatedPost) {
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

    public void findByIdAndDelete(UUID id) {
        Iterator<BlogPost> iterator = this.posts.iterator();

        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
