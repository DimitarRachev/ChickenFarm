package Readers;

import Entities.Bird;
import Entities.Chicken;
import Entities.Egg;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BirdTextReader implements BirdReader {

    @Override
    public Set<Bird> read(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Set<Bird> toReturn = new TreeSet<>();

        reader.lines().forEach(l -> {
            String[] line = l.split(" ");
            Bird bird = null;
            if (line.length == 1) {
                Bird.setSerialNumber(Integer.parseInt(line[0]));
            } else {
                if ("Chicken".equals(line[0])) {
                    bird = new Chicken(line[1]);
                } else {
                    bird = new Egg(line[1]);
                }

                bird.setWeeksLived(Integer.parseInt(line[2]));
                toReturn.add(bird);
            }
        });

        reader.close();
        return toReturn;
    }

}
