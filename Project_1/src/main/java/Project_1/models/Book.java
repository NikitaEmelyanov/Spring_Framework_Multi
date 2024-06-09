package Project_1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min = 2, max = 30, message = "Название книги должно быть от 2 до 100 символов длинной ")
    private String title;
    @NotEmpty(message = "Поле Автор не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя автора  должно быть от 2 до 100 символов длинной ")
    private String author;
    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    private int year;

    public Book(String nameBook, String author, int year) {
        this.title = nameBook;
        this.author = author;
        this.year = year;

    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
