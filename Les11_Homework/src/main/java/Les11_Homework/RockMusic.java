package Les11_Homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
private List<String> songs = new ArrayList<>();{
    songs.add("Wind cries Mary");
    songs.add("Bohemian Rhapsody");
    songs.add("I Just Wanna Have Something to Do");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}
