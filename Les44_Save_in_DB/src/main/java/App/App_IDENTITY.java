package App;


import model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; //Должен быть импорт их этого пакета для конфигурации с Hibernate

public class App_IDENTITY {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        // Создаем объект класса Configuration из org.hibernate.cfg.Configuration и используем метод
        // addAnnotatedClass(Person.class) для передачи сущности в конфигурацию (класс, который
        // помечен аннотацией @Entity)

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //С помощью метода buildSessionFactory() получаем SessionFactory, чтобы из него получить
        // сессию для Hibernate.

        Session session = sessionFactory.getCurrentSession(); // Получили сессию для работы с Hibernate

        try {
            session.beginTransaction(); //Начинаем транзакцию

            Person person1 = new Person("Test1",30);
            Person person2 = new Person("Test2",40);
            Person person3 = new Person("Test3",50);

            session.save(person1); // Метод для сохранения объектов
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit(); // Закрытие транзакции
        } finally {
            sessionFactory.close(); // Закрытие sessionFactory. Для точного закрытия sessionFactory
            // можно обернуть предыдущие итерации в блок try, а закрытие sessionFactory обернуть
            // в блок finally. Это будет наиболее корректно
        }
    }
}
