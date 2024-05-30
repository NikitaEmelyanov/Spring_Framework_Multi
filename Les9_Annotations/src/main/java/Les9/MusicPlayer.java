package Les9;

public class MusicPlayer {
    private Music music;

    public MusicPlayer(Music music){
        this.music= music;
    }

    public void playMusic(){
        System.out.println("Plaing: "+ music.getSong());
    }
}
