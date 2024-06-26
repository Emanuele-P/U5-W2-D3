package ep2024.u5w2d3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String mail;
    private LocalDate dayOfBirth;
    private String avatar;
}
