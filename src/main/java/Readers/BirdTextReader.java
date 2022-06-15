package Readers;

import Entities.Bird;
import Entities.Chicken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BirdTextReader implements BirdReader {

    @Override
    public Set<Bird> read(File file) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\savedBirds.txt"));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Set<Bird> toReturn = new HashSet<>();
        reader.lines().forEach(l -> {
            String[] line = l.split(" ");
            Chicken chicken = new Chicken("Chiken" + line[0] + "\\");
            chicken.setWeeksLived(Integer.parseInt(line[1]));
            toReturn.add(chicken);
        });
        reader.close();
        return toReturn;
    }

}
