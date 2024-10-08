package model;

import jakarta.persistence.*;

import java.util.List;

@Entity // Аннотация помечает те классы, которые связаны с БД (англ. Сущность)
@Table(name="Person") // Аннотация указывает название таблицы в БД
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Item> items;

    public Person(){}

    public Person(String name, int age) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
