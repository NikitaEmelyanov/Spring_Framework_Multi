/**
 * 4. Инверсия управления. Inversion of Control (IoC)
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Мотивация использования Inversion of Control (IoC)
        // MusicPlayer ----> ClassicalMusic
        //MusicPlayer зависит от ClassicalMusic
        //MusicPlayer сам создает объект ClassicalMusic
        //Вместо этого мы хотим передавать объект ClassicalMusic внутрь MusicPlayer -
        // это и называется инверсия управления (IoC)

        //Для использования инверсии управления можно создать интерфейс Music и получаем
        // следующую зависимость:
        //ClassicalMusic ----> Music <---- MusicPlayer
        //Программирование на уровне интерфейсов - хороший архитектурный паттерн

        //Spring можно конфигурировать с помощью:
        //XML файла конфигурации (Старый способ, но многие существующие приложения до сих пор
        // его используют)
        //Java аннотаций и немного XML (современный способ)
        // Вся конфигурация на Java коде (современный способ)

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Music music  = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer= new MusicPlayer(music);
        musicPlayer.playMusic();

        context.close();
    }
}
