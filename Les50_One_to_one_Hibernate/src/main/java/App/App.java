package App;



import model.Passport;
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
                        .addAnnotatedClass(Passport.class); // Добавление 2х сущностей


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession(); // Получили сессию для работы с Hibernate

        try {
            session.beginTransaction(); //Начинаем транзакцию

            Person person = new Person("Test person",50);
            Passport passport = new Passport(12345);
            // Теперь не нужно передавать человека в аргументе, так как связь установится в методе
            // setPassport()

            person.setPassport(passport);

            session.save(person); // И благодаря каскадированию все будет сохраняться


            person = session.get(Person.class,1);
            System.out.println(person.getPassport().getPassportNumber()); // Получение номера паспорта у человека

            person = session.get(Person.class,1);
            System.out.println(passport.getPerson().getName()); // Получение человека по номеру паспорта

            person = session.get(Person.class,1);
            person.getPassport().setPassportNumber(77777); // Изменение паспорта

            person = session.get(Person.class,1);
            session.remove(person); //Удаление человека

            session.getTransaction().commit(); // Закрытие транзакции

        } finally {
            sessionFactory.close();
        }
    }
}
