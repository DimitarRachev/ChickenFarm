package Readers;

import Entities.Bird;
import Entities.Chicken;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BirdJsonReader implements BirdReader {


    public BirdJsonReader() {

    }

    @Override
    public  Set<Bird> read(File file) throws IOException {
//        FileReader reader = new FileReader("src\\main\\resources\\savedBirds.json");
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        Set<Bird> toReturn = new HashSet<>();

        Set birds = gson.fromJson(reader, HashSet.class);
        //TODO find a better way to do this
        for (Object bird : birds) {
            String s = gson.toJson(bird);
            Chicken chicken = gson.fromJson(s, Chicken.class);
            toReturn.add(chicken);
        }
        reader.close();
        return toReturn;
    }
}
