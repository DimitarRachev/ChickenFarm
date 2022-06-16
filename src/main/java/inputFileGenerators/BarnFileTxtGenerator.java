package inputFileGenerators;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BarnFileTxtGenerator {

    //Used for initial generation of the needed files
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(11).append(System.lineSeparator());
        for (int i = 1; i <= 10; i++) {
            sb.append("Chicken").append(" ").append("Chicken").append(i).append("\\").append(" ").append(random.nextInt(5) + 1);
            if (i < 10) {
                sb.append(System.lineSeparator());
            }
        }
        FileWriter out = new FileWriter("src\\main\\resources\\savedBirds.txt");
        out.write(sb.toString());
        out.close();
    }
}
