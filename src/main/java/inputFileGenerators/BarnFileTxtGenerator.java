package inputFileGenerators;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BarnFileTxtGenerator {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append(i).append(" ").append(random.nextInt(5) + 1);
            if (i < 10) {
                sb.append(System.lineSeparator());
            }
        }
        FileWriter out = new FileWriter("src\\main\\resources\\savedBirds.json");
        out.write(sb.toString());
        out.close();
    }
}
