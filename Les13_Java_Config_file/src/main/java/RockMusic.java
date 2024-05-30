//@Component
//@Scope("prototype") //Такой же синтаксис как и в XML файле (singleton или prototype)
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
