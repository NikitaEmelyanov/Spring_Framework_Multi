/**
 * 7. Bean scope (Область видимости бинов)
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Singleton - Scope, который используется по умолчанию
        //- По умолчанию создается один объект (он создается до вызова метода getBean())
        //- При всех вызовах getBean() возвращается ссылка на один и тот же единственный объект
        //Scope Singleton чаще всего используется тогда, когда у нашего бина нет изменяемых
        // состояний (stateless). Потому что если будем изменять состояние у Singleton бина,
        // столкнемся с проблемой: Если мы несколько раз ссылаемся на один объект и он был
        // изменен или переопределен то и все другие ссылки на этот объект так же изменятся

        //Prototype - Scope, который каждый раз создает новый объект при вызове getBean()
        // Scope Prototype чаще всего используется, когда у нашего бина есть изменяемые
        // состояния (Stateful)


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = firstMusicPlayer == secondMusicPlayer;
        System.out.println(comparison);

        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        context.close();
    }
}
//После строки class в конфигурационном файле можно указать строку scope = "singleton">
// (не обязательно, так как указывается по умолчанию и явное указание данного scope излишне)
// или  "prototype"> и тогда при вызове метода getBean() будет создаваться новый объект
// и выделяться память под каждый, соответственно проверка хэша и изменения громкости будет
// изменяться только у одного объекта