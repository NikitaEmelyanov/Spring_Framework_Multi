package Project_1.dao;

import Project_1.models.Book;
import Project_1.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
@Autowired //Внедрение JdbcTemplate
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {
       return jdbcTemplate.query("SELECT * FROM Person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
    return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",new Object[]{id},
        new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
    jdbcTemplate.update("INSERT INTO Person(full_name,yearofbird) VALUES (?, ?)",
            person.getFullName(),person.getYearOfBird());

    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?,yearofbird=? WHERE id=?",
                updatedPerson.getFullName(),updatedPerson.getYearOfBird(),id) ;
    }

    public void delete(int id) {
    jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }

    // Для валидности уникального ФИО
    public Optional<Person> getPersonByFullName(String fullName) {
    return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?",new Object[]{fullName},
            new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
    //Здесь Join не нужен. И так уже получили человека с помощью отдельного метода
    public List<Book> getBooksByPersonId(int id) {
    return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?",new Object[]{id},
            new BeanPropertyRowMapper<>(Book.class));
    }
}