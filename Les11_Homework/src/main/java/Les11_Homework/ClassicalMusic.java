package Les11_Homework;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Hungarian Rhapsody");
        songs.add("Morning");
        songs.add("Wedding March");
    }

    @Override
    public List<String> getSongs() {
        return songs;
    }
}

