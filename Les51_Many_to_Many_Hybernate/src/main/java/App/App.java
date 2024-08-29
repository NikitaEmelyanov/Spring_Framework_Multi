package App;

import model.Actor;
import model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).
                addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //try with resources (try c ресурсами)
        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie movie = new Movie("Pulp fiction", 1994);    <-- Сначала вносили фильмы и сохраняли их (1)
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            //Arrays.asList() == List.of, но последний не изменяемый, то есть нельзя обратиться по индексу и положить нового актера
//            movie.setActors(new ArrayList<>(List.of(actor1, actor2))); // Создали пустой список, так как в списке который уже создан null
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie))); // связь с другой стороны
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

//            session.save(movie);     <-- сохранение (1)
//            session.save(actor1);
//            session.save(actor2); // Сохранение вручную так как нет каскадирования

//            Movie movie = session.get(Movie.class,1);
//            System.out.println(movie.getActors()); // Вывод фильма (2)
//
//            Actor actor = session.get(Actor.class,1);
//            System.out.println(actor.getMovies()); // Вывод Актера (2)
//
//            Movie movie1 = new Movie("Reservoir Dogs", 1992); // Добавление фильма с список фильмов (3)
//            Actor actor1 = session.get(Actor.class,1);
//
//            movie1.setActors(new ArrayList<>(Collections.singletonList(actor1)));
//            actor1.getMovies().add(movie1);
//            session.save(movie1);

            Actor actor = session.get(Actor.class,2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0); // Удаление со стороны актера (4)
            movieToRemove.getActors().remove(actor); //удаление со стороны фильма (4)
            // для правильной работы нужно сгенерить equals() и hashCode() в Movie и Actors


            session.getTransaction().commit();
        }
    }
}
