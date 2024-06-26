package ep2024.u5w2d3.services;

import ep2024.u5w2d3.entities.Author;
import ep2024.u5w2d3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author save(Author body) {
        Random random = new Random();
        body.setId((random.nextInt(10000, 99999)));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + body.getSurname());
        this.authors.add(body);
        return body;
    }

    public Author findByID(int id) {
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

    public Author findByIdAndUpdate(int id, Author updatedAuthor) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setName((updatedAuthor.getName()));
                found.setSurname((updatedAuthor.getSurname()));
                found.setMail((updatedAuthor.getMail()));
                found.setDayOfBirth((updatedAuthor.getDayOfBirth()));
                found.setAvatar("https://ui-avatars.com/api/?name=" + updatedAuthor.getName() + updatedAuthor.getSurname());
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new NotFoundException(id);
        }
    }

    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authors.iterator();

        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
