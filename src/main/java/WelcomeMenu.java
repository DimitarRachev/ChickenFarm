import Exeptions.FileNotRecognizedException;
import Readers.BirdReader;
import Readers.BirdReaderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WelcomeMenu {

    public static Barn printWelcomeMenuAndReturnBarn(Scanner scanner) {
        System.out.println("Enter the name of the file to open (empty for default): ");
        String input = scanner.nextLine().trim();

        File file = new File("src\\main\\resources\\" + input);
        if (!file.isFile()) {
//          different default files
//          file = new File("src\\main\\resources\\savedBirds.json");
            file = new File("src\\main\\resources\\savedBirds.txt");
        }

        Barn barn = new Barn();
        try {
            BirdReader reader = BirdReaderFactory.getReader(file);
            barn.setBirds(reader.read(file));
        } catch (FileNotRecognizedException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        return barn;
    }
}
