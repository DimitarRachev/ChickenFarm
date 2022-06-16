package Writers;

import Entities.Bird;
import Exeptions.FileNotRecognizedException;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class BirdWriterFactory {
    public static BirdWriter getWriter(File file, Set<Bird> birds) throws FileNotFoundException, FileNotRecognizedException {
        String[] path = file.getPath().split("\\.");
        String type = path[path.length - 1];
        switch (type) {
            case "json":
                return new BirdJsonWriter(birds, file);
            case "txt":
                return new BirdTextWriter(birds, file);
            default:
                throw new FileNotRecognizedException("Extension not recognized: " + type);
        }
    }
}
