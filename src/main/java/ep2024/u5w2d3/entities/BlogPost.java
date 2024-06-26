package ep2024.u5w2d3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BlogPost {
    private int id;
    private String genre;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
