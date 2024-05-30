package Les10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
//  @Autowired //Внедрение зависимости через поле (можно внедрять зависимости в приватные поля)
//  private Les10.Music music;
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
@Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }
    //Для внедрения 2х и более элементов нужно создать конструктор с этими полями и над
    // ним указать аннотацию @Autowired

//  @Autowired - Внедрение зависимости через конструктор
//  public Les10.MusicPlayer(Les10.Music music) {this.music = music;}
//  @Autowired - Внедрение зависимости через сеттер (сам метод может зазываться как угодно)
//  public void setMusic(Les10.Music music) {this.music = music;}

    public String playMusic(){
    return "Plaing: "+ classicalMusic.getSong();
    }
    // Переопределили метод чтобы он выводил строку, так как в переопределенном методе
    // toString() в классе Les10.Computer выводится строка

}
