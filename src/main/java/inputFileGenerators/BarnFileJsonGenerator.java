package inputFileGenerators;

import Entities.Bird;
import Entities.Chicken;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BarnFileJsonGenerator {
    public static void main(String[] args) throws IOException {
        Set<Bird> set = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Chicken chicken = new Chicken("Chicken" + (i + 1) + "\\");
            chicken.setWeeksLived(random.nextInt(5) + 1);
            set.add(chicken);
        }

        Gson gson = new Gson();
        FileWriter writer = new FileWriter("src\\main\\resources\\savedBirds.json");
        gson.toJson(set, writer);
        writer.close();
    }
}
