package ep2024.u5w2d3.services;

import ep2024.u5w2d3.entities.BlogPost;
import ep2024.u5w2d3.exceptions.BadRequestException;
import ep2024.u5w2d3.exceptions.NotFoundException;
import ep2024.u5w2d3.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostsService {
    @Autowired
    PostsRepository postsRepository;

    public Page<BlogPost> getPosts(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 20) pageSize = 20;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return postsRepository.findAll(pageable);
    }

    public BlogPost save(BlogPost newPost) {
        this.postsRepository.findByTitle(newPost.getTitle()).ifPresent(
                post -> {
                    throw new BadRequestException("A post entitled " + newPost.getTitle() + " exists already!");
                }
        );

        return postsRepository.save(newPost);
    }

    public BlogPost findById(UUID postId) {
        return this.postsRepository.findById(postId).orElseThrow(() -> new NotFoundException(postId));
    }

    public void findByIdAndDelete(UUID postId) {
        BlogPost found = this.findById(postId);
        this.postsRepository.delete(found);
    }

    public BlogPost findByIdAndUpdate(UUID postId, BlogPost updatedPost) {
        BlogPost found = this.findById(postId);
        found.setGenre(updatedPost.getGenre());
        found.setTitle(updatedPost.getTitle());
        found.setCover(updatedPost.getCover());
        found.setContent(updatedPost.getContent());
        found.setReadingTime(updatedPost.getReadingTime());
        return this.postsRepository.save(found);
    }
}
