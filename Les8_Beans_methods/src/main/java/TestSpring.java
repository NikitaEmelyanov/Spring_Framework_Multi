/**
 * 7. 8. Жизненный цикл бина (Bean Lifecycle). Init, Destroy и Factory методы
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Жизненный цикл бина (Bean Lifecycle)
        //Запуск Spring приложения --> Запускается Spring контейнер --> Создается объект бина
        // --> В бин внедряются зависимости Dependency Injection) --> Вызывается указанный
        // init-method --> Бин готов к использованию --> Использование --> Вызывается указанный
        // destroy-method --> Остановка Spring приложения

        //init-method - Метод, который запускается в ходе инициализации бина
        //Инициализация ресурсов, обращение к внешним файлам, запуск БД

        //destroy-method - Метод, который запускается в ходе уничтожения бина
        // (при завершении работы приложения)
        // Очищение ресурсов, закрытие потоков ввода/вывода, закрытие доступа к БД

        //Init-method и destroy-method создаются в классе бина. в конфиг файле будут иметь такой
        // синтаксис, где doMyInit() - Init-method и doMyDestroy() - destroy-method (методы
        // нужно создать в ClassicalMusic вручную и прописать механику выполнения методом
        // (Названия могут быть любыми))
        //<bean id = "musicBean"
        //      class="Block_1_Spring_Core.Les8_Beans_methods.ClassicalMusic"
        //      init-method="doMyInit"
        //      destroy-method="doMyDestroy">
        //</bean>

        //Тонкости init и destroy методов
        //Модификатор доступа
        //-У этих методов может быть любой модификатор доступа (public, protected, private)
        //Тип возвращаемого значения
        //-Может быть любой, но чаще всего используется void (так как нет возможности
        // получить возвращаемое значение)
        //Название метода
        //-Название может быть любым
        //Аргументы метода
        //-Эти методы не должны принимать на вход какие-либо аргументы

        //Еще одна тонкость
        //Для бинов со scope "prototype" Spring не вызывает destroy метод.
        //Spring не берет на себя полный жизненный цикл бинов со scope "prototype". Spring
        // отдает prototype бины клиенту и больше о них не заботится (в отличии от
        // singleton бинов)

        //Factory-method
        //Фабричный метод (англ. Factory Method) - это паттерн программирования.
        //Вкратце: паттерн "фабричный метод" предлагает создавать объекты не напрямую,
        // используя оператор new, а через вызов особого фабричного метода. Объекты все равно
        // будет создаваться при помощи new, но делать это будет фабричный метод
        // (иногда это бывает полезно).
        //<bean id="musicBeans
        //      class="Block_1_Spring_Core.Les8_Beans_methods.ClassicalMusic"
        //      factory-method ="getClassicalMusic">
        //</bean>

        //Важная тонкость при использовании factory-method используется scope singleton,
        // то есть даже учитывая, то что фабричный метод возвращает новое значение, оно
        // будет одним и тем же, поскольку scope не изменился

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);

        System.out.println(classicalMusic.getSong());
//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean comparison = firstMusicPlayer == secondMusicPlayer;
//        System.out.println(comparison);
//
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(10);
//
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

        context.close();
    }
}
