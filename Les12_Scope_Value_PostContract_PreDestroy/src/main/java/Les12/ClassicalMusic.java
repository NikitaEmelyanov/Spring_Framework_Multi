package Les12;

import org.apache.pulsar.shade.javax.annotation.PostConstruct;
import org.apache.pulsar.shade.javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {

    @PostConstruct //Аналог Init метода в XML файле
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }
    @PreDestroy // Аналог Destroy метода в XML файле
     public void doMYDestroy(){
         System.out.println("Doing my destruction");
     }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
