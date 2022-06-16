package Writers;

import Entities.Bird;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class BirdTextWriter implements BirdWriter {
    private Set<Bird> birds;
    private File file;

    public BirdTextWriter(Set<Bird> birds, File file) {
        this.birds = birds;
        this.file = file;
    }

    @Override
    public boolean write() {
        try {
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            StringBuilder sb = new StringBuilder();

            int serialNumber = Bird.getSerialNumber();
            sb.append(serialNumber).append(System.lineSeparator());
            for (Bird bird : birds) {
                String name = bird.getName();
                int weeksLived = bird.getWeeksLived();
                String type = bird.getType();
                sb.append(type).append(" ").append(name).append(" ").append(weeksLived).append(System.lineSeparator());
            }

            writer.write(sb.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
