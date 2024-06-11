package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Аннотация помечает те классы, которые связаны с БД (англ. Сущность)
@Table(name="Person") // Аннотация указывает название таблицы в БД
public class Person {

    @Id // Аннотация показывает Hibernate, что столбец является первичным ключом PRIMARY KEY
    @Column(name = "id") // Аннотация для сопоставления поля колонке из таблицы БД
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    // Все классы помеченные аннотацией @Entity должны содержать пустой конструктор и поле id.
    // Hibernate может работать только с теми классами, которые помечены аннотаций @Entity

    public Person(){}

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
