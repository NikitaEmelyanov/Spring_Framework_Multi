package App;


import model.Movies;
import model.Director;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; //Должен быть импорт их этого пакета для конфигурации с Hibernate

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                        .addAnnotatedClass(Movies.class); // Добавление 2х сущностей


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession(); // Получили сессию для работы с Hibernate

        try {
            session.beginTransaction(); //Начинаем транзакцию

            Movies movies = session.get(Movies.class,3); //Получение фильма
            System.out.println(movies);
            System.out.println(movies.getOwner()); // Получение режиссера

            Director director = session.get(Director.class,2);
            Movies newMovie = new Movies("Самый новый фильм",2024,director); // Добавление фильма для режиссера
            session.save(newMovie);
            director.getMovies().add(newMovie); //Сохранение с двух сторон


            Director director1 = new Director("Любое имя",88);
            Movies newMovie1 = new Movies("Фильм новее, чем самый новый",2024,director1);
            director1.setMovies(new ArrayList<>(Collections.singletonList(newMovie1)));
            session.save(director1);
            session.save(newMovie1);


            //Смена владельца у существующего товара
            Director director2 = session.get(Director.class,4);
            Movies movies1 = session.get(Movies.class,1);
            movies1.getOwner().getMovies().remove(movies1); // Удаление товара у старого владельца
            movies1.setOwner(director2); //Меняем владельца товара
            director2.getMovies().add(movies1); // добавляем владельцу товар

            session.getTransaction().commit(); // Закрытие транзакции

        } finally {
            sessionFactory.close();
        }
    }
}
