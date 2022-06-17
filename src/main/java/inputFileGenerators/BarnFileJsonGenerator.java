package inputFileGenerators;


import Entities.Bird;
import Entities.Chicken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BarnFileJsonGenerator {

    //Used for initial generation of the needed Json
    public static void main(String[] args) throws IOException {
      Set<Bird> set = new HashSet<>();
        Random random = new Random();
//        Barn barn = new Barn();
        for (int i = 0; i < 10; i++) {
            Chicken chicken = new Chicken("Chicken" + (i + 1) + "\\");
            chicken.setWeeksLived(random.nextInt(5) + 1);
            set.add(chicken);
        }
        Bird.setSerialNumber(11);

        GsonBuilder gsonBuilder  = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT);
        Gson gson = gsonBuilder.create();

        FileWriter writer = new FileWriter("src\\main\\resources\\savedBirds.json");
        gson.toJson(set, writer);
        writer.close();
    }
}
