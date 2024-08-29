package App;


import model.Item;
import model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; //Должен быть импорт их этого пакета для конфигурации с Hibernate

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                        .addAnnotatedClass(Item.class); // Добавление 2х сущностей


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession(); // Получили сессию для работы с Hibernate

        try {
            session.beginTransaction(); //Начинаем транзакцию

            Person person = new Person("Test cascading",30);

            person.addItem( new Item("item1"));
            person.addItem( new Item("item2")); // Упростили код с помощью нового метода addItem
            person.addItem( new Item("item3"));

            session.save(person);
            //Заменили метод save на метод persist, для корректной работы каскадирования
            // session.persist(item) - Hibernate сам это делает, нам это делать не нужно, если бы
            // связанных объектов было бы много Hibernate сохранял бы их все

//____________________________Разница между методами save() и persist()________________________________
//       Serializable save(Object var1);          |             void persist (Object var1);
//------------------------------------------------|----------------------------------------------------
// Из самой библиотеки Hibernate (есть только у   | Из спецификации JPA (Java Persistence API) - любой
// Hibernate, нет у других JPA библиотек)         | JPA провайдер будет иметь этот метод
//                                                |
// Возвращает значение первичного ключа для       | Ничего не возвращает
// добавления сущности                            |
//                                                | Такого не гарантирует (значение первичного ключа
// Гарантирует, что значение первичного ключа     | выставится, но не обязательно сразу послу вызова
// будет определено сразу после вызова метода     | метода)
//----------------------------------------------------------------------------------------------------
// В остальном, оба метода очень похожи и в большинстве случаев нет разницы, какой из них использовать.


            session.getTransaction().commit(); // Закрытие транзакции

        } finally {
            sessionFactory.close();
        }
    }
}
