package Les9; /**
 * 9. Аннотации. Введение
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Java Аннотации - это специальный тип комментариев в вашем коде с помощью которых можно:
        //1) Передавать какие - либо инструкции для Java компилятора (пример: @Override)
        //2) Передавать какие - либо инструкции для анализаторов исходного кода
        //3) Передавать метаданные, которые могут быть использованы либо вашем Java
        // приложением (с помощью рефлексии), либо другими приложениями или фреймворками
        // (пример: Spring Framework)

        //Зачем использовать Аннотации ?
        //1) Короче, чем XML конфигурация
        //2) Удобнее, чем XML конфигурация
        //3) Код становится более читабельным

        //Как работает конфигурация с помощью аннотаций ?
        //1) Spring сканирует все ваши классы
        //2) Находит классы со специальными аннотациями и автоматически создает бины из
        // этих классов

        //Аннотация @Component
        //1) Помечаем ей класс, если хотим, чтобы Spring Framework создал бин из этого класса
        //2) Именно эту аннотацию Spring Framework ищет, когда сканирует все ваши классы
        //3) Можно указывать id для создаваемого бина, можно не указывать (тогда название
        // будет: название_класса_с_маленькой_буквы)
        //Аннотация @Component должна прописываться именно внутри класса, а не интерфейса,
        // так как необходимо создать объект класса, а объект интерфейса создать нельзя
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Music music = context.getBean("rockMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();

        Music music2 = context.getBean("classicalMusic", Music.class);

        MusicPlayer classicalMusicPlayer = new MusicPlayer(music2);

        classicalMusicPlayer.playMusic();

        context.close();
    }
}
    // <context:component-scan base-package="Block_1_Spring_Core.Les9_Annotations"/> -Cтрока для сканирования компонентов