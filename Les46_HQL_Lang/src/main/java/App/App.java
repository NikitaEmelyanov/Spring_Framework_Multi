package App;


import model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; //Должен быть импорт их этого пакета для конфигурации с Hibernate

import java.util.List;

public class App {
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

            List<Person> people = session.createQuery("FROM Person").getResultList();
            //Используем HQL запрос и обращаемся к сущности Person, далее с помощью метода
            // getResultList() получаем список людей и складываем его в переменную List<Person> people

            for (Person person : people)

                System.out.println(person);

            List<Person> people2 = session.createQuery("FROM Person where age > 40").getResultList();
            //Вывод людей с возрастом больше 40
            for (Person person : people2)
                System.out.println(person);

            List<Person> people3 = session.createQuery("FROM Person where name LIKE 'S%'").getResultList();
            //Получаем только тех людей, у которых имя начинается на S, а знак % означает любое
            // количество любых символов после S. Для этого применяем LIKE
            for (Person person : people3)
                System.out.println(person);

            session.createQuery("update Person set name ='Test' where age <40").executeUpdate();
            //Изменяем имя на Test для всех людей с возрастом < 40 с помощью метода executeUpdate()

            session.createQuery("delete from Person where age<40").executeUpdate();
            //Удаляем всех людей с возрастом < 40 с помощью метода executeUpdate()


            session.getTransaction().commit(); // Закрытие транзакции

        } finally {
            sessionFactory.close(); // Закрытие sessionFactory. Для точного закрытия sessionFactory
            // можно обернуть предыдущие итерации в блок try, а закрытие sessionFactory обернуть
            // в блок finally. Это будет наиболее корректно
        }
    }
}
