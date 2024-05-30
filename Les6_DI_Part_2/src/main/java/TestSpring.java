import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 6. Внедрение зависимостей. Dependency Injection (DI). Часть 2
 * Внедрение зависимостей через сеттер
 * Внедрение простых значений и строк
 * Внедрение значения из внешнего файла
 * Внедрение листа зависимостей
 */
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusicList();

        context.close();
    }
}
// Теперь Spring создает объект MusicPlayer с пустым конструктором, затем с помощью метода
// setMusic назначает этому объекту зависимость musicBean
// Тег <property в конфигурационном файле назначает значение для сеттера
//Параметр value позволяет внести значение, при получении переменной через сеттер

//Для внедрения зависимости из внешнего файла создаем в папке ресурсы файл
// musicPlayer.properties. Расширение файла .properties говорит о том что файл создан
// в формате ключ/значение properties (англ. Свойства). Для импорта этого файла в конфиг файл
//нужно использовать тег <context:property-placeholder в качестве аргумента нужно указать
// путь к файлу со значениями location = classpath: musicPlayer.properties"/>.
// Где classpath: - это ссылка на папку с ресурсами и после двоеточия нужно указать
// название файла