package Readers;

import Exeptions.FileNotRecognizedException;

import java.io.File;
import java.io.FileNotFoundException;

public class BirdReaderFactory {
    public static BirdReader getReader(File file) throws FileNotFoundException, FileNotRecognizedException {
        if (!file.isFile()) {
            throw new FileNotFoundException("File not fount: " + file.getAbsolutePath());
        }
        String[] path = file.getPath().split("\\.");
        String type = path[path.length - 1];
        switch (type) {
            case "json" :
                return new BirdJsonReader();
            case "txt" :
                return new BirdTextReader();
            default:
                throw new FileNotRecognizedException("Extension not recognized: " + type);
        }
    }
}
