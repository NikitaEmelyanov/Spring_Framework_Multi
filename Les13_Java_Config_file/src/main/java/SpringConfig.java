import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("Block_1_Spring_Core.Les13_Java_Config_file")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean //Ручное создание бинов, обычно Spring сам их создает с помощью @Component и @Autowired
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();
    }
    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
    @Bean MusicPlayer musicPlayer(){
        return new MusicPlayer(rockMusic(),classicalMusic());
    }
    @Bean Computer computer (){
        return new Computer(musicPlayer());
    }
}
