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

            Person person = session.get(Person.class,3); // Получение человека
            System.out.println(person);

            List<Item> items = person.getItems(); //Получение его заказов
            System.out.println(items);

            Item item = session.get(Item.class, 5);  // Получение товара
            System.out.println(item);

            Person person1 = item.getOwner(); //Получение владельца заказа
            System.out.println(person1);

            Person person2 = session.get(Person.class,3);
            Item newItem = new Item("Item from Hibernate",person2); //Создание нового товара
            session.save(newItem); // Сохранение нового товара
            //Поскольку связь двухсторонняя, можно создавать новый объект только на одной стороне,
            // по крайней мере для Hibernate, но так же стоит учесть, что Hibernate кэширует объекты
            // для своей оптимизации и если получать объект из таблицы, полученный результат может
            // быть предыдущим, поскольку в обратную сторону связь не установлена, для этого
            // указываем связь в обратную сторону на следующей строке
            person2.getItems().add(newItem); //Желательно всегда назначать отношения с двух сторон

            //Создание нового человека с новым заказом
            Person person3 = new Person("Test person",99);
            Item newItem1 = new Item("Item from Hibernate 2",person3);
            person3.setItems(new ArrayList<>(Collections.singletonList(newItem1))); //Метод singletonList добавляет один объект в лист
            session.save(person3);
            session.save(newItem);

            //Удаление всех объектов у человека
            Person person4 = session.get(Person.class,3);
            List<Item> items1 = person4.getItems();
            for (Item item1: items1) // Проходимся по всему списку заказов человека
                session.remove(item1); // Удаляем все заказы у человека
            person4.getItems().clear(); // Удаляем у человека все заказы (обратная сторона), чтобы совпадал кеш

            //Удаление самого человека
            Person person5 = session.get(Person.class,5);
            session.remove(person5);
            person5.getItems().forEach(i->i.setOwner(null)); // Обратная сторона для правильного состояния Hibernate кеша

            //Смена владельца у существующего товара
            Person person6 = session.get(Person.class,4);
            Item item1 = session.get(Item.class,1);
            item1.getOwner().getItems().remove(item1); // Удаление товара у старого владельца
            item1.setOwner(person6); //Меняем владельца товара
            person6.getItems().add(item1); // добавляем владельцу товар

            session.getTransaction().commit(); // Закрытие транзакции

        } finally {
            sessionFactory.close();
        }
    }
}
