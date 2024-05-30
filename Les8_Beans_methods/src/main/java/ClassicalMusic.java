public class ClassicalMusic implements Music {
    private ClassicalMusic(){}
    //Приватный конструктор не даст создавать новый объект с помощью new

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
    //Метод должен быть статическим, чтобы вызывать его на классе, а не на объекте. Иначе
    // не получится создать новый объект из-за приватного конструктора.
    // А сам метод возвращает новый объект класса.
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
