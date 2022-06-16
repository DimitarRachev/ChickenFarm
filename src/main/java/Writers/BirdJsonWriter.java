package Writers;

import Entities.Bird;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class BirdJsonWriter implements BirdWriter {
    private Set<Bird> birds;
    private File file;

    public BirdJsonWriter(Set<Bird> birds, File file) {
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
            GsonBuilder gsonBuilder  = new GsonBuilder();
            gsonBuilder.excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT);
            Gson gson = gsonBuilder.create();
            gson.toJson(birds, writer);
            writer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
   }
}
