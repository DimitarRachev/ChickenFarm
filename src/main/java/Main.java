
import Entities.WeekState;
import Exeptions.FileNotRecognizedException;
import Readers.BirdReader;
import Readers.BirdReaderFactory;
import Writers.BirdWriter;
import Writers.BirdWriterFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barn barn = getBarn();

        int weeksToRun = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < weeksToRun; i++) {
            WeekState weekState = WeekState.valueOf(scanner.nextLine().toUpperCase());
            barn.anotherWeekPassed(weekState);
        }

        System.out.println(barn.getState());

        saveFileMenu(scanner, barn);
    }

    private static Barn getBarn() {
        Barn barn = new Barn();

//        File file = new File("src\\main\\resources\\savedBirds.json");
      File file = new File("src\\main\\resources\\savedBirds.txt");

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

    private static void saveFileMenu(Scanner scanner, Barn barn) {
        System.out.println("Would you like to save it to file? (Y/N): ");
        String line = scanner.nextLine();
        if ("Y".equals(line)) {
            System.out.println("Enter the name of the file:");
            String name = scanner.nextLine();
            System.out.println("Please select format of the file(1 - JSON, 2 - TXT) :");
            String format = scanner.nextLine();
            File output;
            if ("1".equals(format)) {
                output = new File("src\\main\\resources\\" + name + ".json");
            } else {
                output = new File("src\\main\\resources\\" + name + ".txt");
            }

            try {
                BirdWriter writer = BirdWriterFactory.getWriter(output, barn.getBirds());
                if (writer.write()) {
                    System.out.println("File saved successfully in  : " + output.getAbsolutePath());
                } else {
                    System.out.println("There was a problem saving file at: " + output.getAbsolutePath());
                }
            } catch (FileNotFoundException | FileNotRecognizedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
