package Readers;

import Entities.Bird;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public interface  BirdReader {

     Set<Bird> read(File file)  throws IOException;
}
