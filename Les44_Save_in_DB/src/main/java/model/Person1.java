package model;

import jakarta.persistence.*;

@Entity // Аннотация помечает те классы, которые связаны с БД (англ. Сущность)
@Table(name="Person1") // Аннотация указывает название таблицы в БД
public class Person1 {

    @Id // Аннотация показывает Hibernate, что столбец является первичным ключом PRIMARY KEY
    @Column(name = "id") // Аннотация для сопоставления поля колонке из таблицы БД
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //Стратегия используется очень редко
    @SequenceGenerator(name="seq_generator_person1",sequenceName = "person1_id_seq", allocationSize = 1)
    //Для данной стратегии нужно дополнительно указать аннотацию @SequenceGenerator( в аргументах
    // нужно указать название сикунса, которое мы даем ему, название сикунса с каким он был создан
    // и назначить самостоятельно величину( в нашем случае id)). При чем, allocationSize нужно указать
    // такой же, как и в БД
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    // Все классы помеченные аннотацией @Entity должны содержать пустой конструктор и поле id.
    // Hibernate может работать только с теми классами, которые помечены аннотаций @Entity

    public Person1(){}

    public Person1(String name, int age) { // Убрали id из конструктора, так как его теперь не передаем, а он генерируется на стороне PostgreSQL
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
