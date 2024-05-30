package Les11_Homework; /**
 * 11. Аннотация @Qualifier (англ. Уточнитель). Внедрение зависимостей (Dependency Injection)
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer",MusicPlayer.class);

        musicPlayer.playMusic(Genre.CLASSICAL);
        musicPlayer.playMusic(Genre.ROCK);
        context.close();
    }
}
