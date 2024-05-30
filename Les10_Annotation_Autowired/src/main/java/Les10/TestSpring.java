package Les10; /**
 * 10. Аннотация @Autowired. Внедрение зависимостей (Dependency Injection)
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Аннотация @Autowired позволяет внедрять зависимости
        //Механика работы аннотации @Autowired
        //В примере в бин musicPlayer необходимо внедрить бин, который реализует интерфейс Les10.Music
        //@Autowired
        //public Les10.MusicPlayer (Les10.Music music) {this.music = music;}
        //1) Spring сканирует все классы с аннотацией @Component и создает бины для этих классов
        //2) Spring сканирует все созданные бины и проверяет, подходит ли хотя бы один бин в
        // качестве зависимости там, где мы указали аннотацию @Autowired
        //3) Если находится один подходящий бин, он внедряется в качестве зависимости
        //4) Если не находится ни одного бина - ошибка
        //5) Если находится несколько подходящих бинов - неоднозначность
        //Аннотация @Autowired подбирает подходящие бины по их типу (класс или интерфейс)
        //Аннотацию @Autowired можно использовать на сеттерах и на конструкторах, помимо полей
        //Аннотация @Autowired внедрит зависимость в приватное поле, даже если нет конструктора
        // или сеттера. Делает она это с помощью рефлексии (Java Reflection API)

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

//        Les10.MusicPlayer musicPlayer = context.getBean("musicPlayer",Les10.MusicPlayer.class);
//        musicPlayer.playMusic();

        Computer computer = context.getBean("computer",Computer.class);
        System.out.println(computer);
        //Конструкция следующая класс Les10.MusicPlayer является частью класса Les10.Computer
        // (Имитация музыкального плеера на компьютере). Есть внешний объект Les10.Computer,
        // объект которого мы получаем в методе main у этого объекта (бина) computer есть
        // зависимость Les10.MusicPlayer, которая внедряется с помощью аннотации @Autowired
        // конструктора класса Les10.Computer. А Les10.MusicPlayer в свою очередь тоже является бином
        // у которого есть 2 зависимости Les10.ClassicalMusic и зависимость Les10.RockMusic эти
        // зависимости тоже внедряются с помощью аннотации @Autowired через конструктор
        // класса Les10.MusicPlayer. Далее у бинов Les10.RockMusic и Les10.ClassicalMusic уже нет зависимостей


        context.close();
    }
}
// P.S.
//Не практике было изучено три способа внедрения зависимостей - через конструктор, через
// сеттеры, напрямую через поле
//Желательно выбрать один из них (любой,т.к. они одинаковые по функциональности) и и
// использовать его повсеместно на протяжении всего проекта, Главное - это не смешивать
// разные стили, а придерживаться выбранного, чтобы избежать путаницы.