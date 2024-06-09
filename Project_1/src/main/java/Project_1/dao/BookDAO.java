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
public class BookDAO {
        private final JdbcTemplate jdbcTemplate;
        @Autowired //Внедрение JdbcTemplate
        public BookDAO(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


        public List<Book> index() {
            return jdbcTemplate.query("SELECT * FROM Book",new BeanPropertyRowMapper<>(Book.class));
        }

        public Book show(int id) {
            return jdbcTemplate.query("SELECT * FROM Book WHERE Id=?",new Object[]{id},
                    new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
        }

        public void save(Book book) {
            jdbcTemplate.update("INSERT INTO Book(nameBook,Author,Year) VALUES (?, ?, ?)",
                    book.getTitle(),book.getAuthor(),book.getYear());
        }

        public void update(int id, Book updatedBook) {
            jdbcTemplate.update("UPDATE Book SET name=?,yearofbird=? WHERE id=?",
                    updatedBook.getTitle(),updatedBook.getAuthor(),updatedBook.getYear(),id) ;
        }

        public void delete(int id) {
            jdbcTemplate.update("DELETE FROM Book WHERE id=?",id);
        }

        //Join'им таблицы Book и Person и получаем человека, которому принадлежит книга с указанным id
        public Optional<Person> getBookOwner(int id) {
            //Выбираем все колонки таблицы Person из объединенной таблицы
            return jdbcTemplate.query("SELECT Person * FROM Book JOIN Person ON Book.person_id = Person.id"
                    +"WHERE Book.id=?",new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
                    .stream().findAny();
    }

    public void release(int id) {jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE id=?",id);
    }

    public void assign(int id, Person selectedPerson) {
            jdbcTemplate.update("UPDATE Book SET person_id=?", selectedPerson.getId(),id);
    }
}

