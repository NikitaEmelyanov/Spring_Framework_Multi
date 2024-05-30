/**
 * 13. Конфигурация с помощью Java кода
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class TestSpring {
    public static void main(String[] args) {
        //Аннотация @Configuration
        //1) Помечает Java класс, который мы хотим использовать для конфигурации Spring приложения
        //2) Пустой конфигурационный Java класс равен по функционалу путому конфигурационному
        // XML файлу
        //3) Для каждого XML тега есть соответствующая аннотация
        //<context:component-scan base-package="..."/>   --->  @ComponentScan("...")
        //<bean id ="musicBean"                           @Bean
        //      class="....ClassicalMusic">    --->       public ClassicalMusic musicBean(){
        //</bean>                                              return new ClassicalMusic();
        //                                                }
        //И так далее для всех тегов, используемых в XML файле есть подходящие аннотации

        //Подробнее от аннотации @Bean
        //Как и в случае с XML конфигурацией по умолчанию у бинов scope == singleton
        //Это значит, что тело @Bean методов по умолчанию вызывается только один раз, а все
        // последующие вызовы Spring прерывает и возвращает уже имеющийся бин из контекста

        //Для внедрений зависимостей из внешнего файла, существует аннотация @PropertySource,
        // где в скобках нужно указать путь до файла, так жа как и XML файле
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        //При использовании конфигурационного Java класса необходимо использовать класс
        // AnnotationConfigApplicationContext, а в качестве аргумента название файла.класс

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        RockMusic rockMusic1 = context.getBean("rockMusic", RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic", RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);



        context.close();
    }
}
