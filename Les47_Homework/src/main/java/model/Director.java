package model;

import jakarta.persistence.*;

import java.util.List;

@Entity // Аннотация помечает те классы, которые связаны с БД (англ. Сущность)
@Table(name="Director") // Аннотация указывает название таблицы в БД
public class Director {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "director_id")
    private List<Movies> movies;

    public List<Movies> getMovies() {
        return movies;
    }
    public Director(){}

    public Director(String name, int age) {
        this.directorId = directorId;
        this.name = name;
        this.age = age;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<model.Movies> getItems() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

