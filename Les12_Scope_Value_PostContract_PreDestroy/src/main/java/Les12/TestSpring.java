package Les12;
/**
 * 12. Аннотации @Scope, @Value, @PostConstruct, @PreDestroy
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "Core_Les12_applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        RockMusic rockMusic1 = context.getBean("rockMusic",RockMusic.class);
        RockMusic rockMusic2 = context.getBean("rockMusic",RockMusic.class);

        System.out.println(rockMusic1 == rockMusic2);

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic",ClassicalMusic.class);



        context.close();
    }
}
