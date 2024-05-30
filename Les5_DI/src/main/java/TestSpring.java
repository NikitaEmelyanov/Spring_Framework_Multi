/**
 * 5. Внедрение зависимостей. Dependency Injection (DI)
 * Внедрение зависимостей с помощью конструктора в XML конфигурацию
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // Типичные шаги в работе со Spring
        // Создаем Java классы (будущие бины)
        // Создаем и связываем бины с помощью Spring (аннотации, XML или Java код)
        //При использовании, все объекты (бины) берутся из контейнера Spring

        //Способы внедрения зависимостей
        //Через конструктор
        //Через Setter
        //Есть множество конфигураций того, как внедрять (scope, factory method и т.д.)
        //Процесс внедрения можно автоматизировать (Autowiring)

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        //Music music  = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer= new MusicPlayer(music);
        //Теперь эти строчки не нужны, так как в ручную переменные теперь создаваться не будут

        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);
        //Теперь переменные можно получить из контекста с помощью метода getBean,
        // где в качестве аргумента указывается id нужного бина, а в качестве второго аргумента передается класс
        musicPlayer.playMusic();

        context.close();

        //Тег <constructor-arg  пишется внутри бина и в этом теге указывается тот аргумент, который будет
        //передаваться при создании бина этого класса
        //ref (англ. ссылка) - параметр для созданного бина
    }
}
