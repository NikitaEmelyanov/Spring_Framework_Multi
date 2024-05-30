public class MusicPlayer {
    private Music music;

    //IoC - Inversion of Control (Инверсия управления)
    public MusicPlayer(Music music){
        this.music= music;
    }

    public void playMusic(){
        System.out.println("Plaing: "+ music.getSong());
    }
}
