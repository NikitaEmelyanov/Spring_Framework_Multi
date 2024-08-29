package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "owner") //,cascade = CascadeType.PERSIST) - не используется для возможности использовать метод save()
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;
    //Каскадирование настраивается в родительском классе с помощью аргумента cascade
    // (CascadeType.PERSIST == Сохранение) или аннотации @Cascade, для этого используется такой
    // синтаксис org.hibernate.annotations.CascadeType.SAVE_UPDATE.  Можно каскадировать несколько
    // CascadeType через запятую, для этого все внутри круглых скобок нужно поместить в фигурные).
    // Можно каскадировать все CascadeType, для этого указывается CascadeType.ALL. Но с этим нужно
    // работать очень аккуратно

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

    public void addItem (Item item){ //Рефакторинг, вынесение создания товара в отдельный метод
        if (this.items == null)
            this.items = new ArrayList<>();

        this.items.add(item);
        item.setOwner(this);
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
