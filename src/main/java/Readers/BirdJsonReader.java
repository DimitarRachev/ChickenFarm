package Readers;

import Entities.Bird;
import Entities.Chicken;
import Entities.Egg;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        FileReader reader = new FileReader(file);
        GsonBuilder gsonBuilder  = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT);
        Gson gson = gsonBuilder.create();
        Set<Bird> toReturn = new HashSet<>();

        Set birds = gson.fromJson(reader, HashSet.class);

        //TODO find a better way to do this
        for (Object bird : birds) {
            String s = gson.toJson(bird);
            Bird toAdd = null;
            Chicken chicken = gson.fromJson(s, Chicken.class);
            int lifeSpan = chicken.getLIFE_SPAN();
            if (lifeSpan == 2) {
                Egg egg  =gson.fromJson(gson.toJson(chicken), Egg.class);
                toAdd = egg;
            } else {
                toAdd = chicken;
            }
            toReturn.add(toAdd);
        }
        reader.close();
        return toReturn;
    }
}
