package ep2024.u5w2d3.services;

import ep2024.u5w2d3.entities.Author;
import ep2024.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author save(Author body) {
        body.setAvatarUrl("https://ui-avatars.com/api/?name=" + body.getName() + body.getSurname());
        this.authors.add(body);
        return body;
    }

    public Author findByID(UUID id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) found = author;
        }
        if (found != null) {
            return found;
        } else {
            throw new NotFoundException(id);
        }
    }

    public Author findByIdAndUpdate(UUID id, Author updatedAuthor) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setName((updatedAuthor.getName()));
                found.setSurname((updatedAuthor.getSurname()));
                found.setMail((updatedAuthor.getMail()));
                found.setDayOfBirth((updatedAuthor.getDayOfBirth()));
                found.setAvatarUrl("https://ui-avatars.com/api/?name=" + updatedAuthor.getName() + updatedAuthor.getSurname());
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new NotFoundException(id);
        }
    }

    public void findByIdAndDelete(UUID id) {
        Iterator<Author> iterator = this.authors.iterator();

        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
