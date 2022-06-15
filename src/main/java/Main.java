
import Entities.Bird;
import Entities.WeekState;
import Exeptions.FileNotRecognizedException;
import Readers.BirdReader;
import Readers.BirdReaderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barn barn = new Barn();
        File file = new File("src\\main\\resources\\savedBirds.json");
//        File file = new File("src\\main\\resources\\savedBirds.txt");

        try {
            BirdReader reader = BirdReaderFactory.getReader(file);
            barn.setBirds(reader.read(file));
            Bird.setSerialNumber(barn.getBirdCount() + 1);
        } catch (FileNotRecognizedException | IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

        int weeksToRun = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < weeksToRun; i++) {
            WeekState weekState = WeekState.valueOf(scanner.nextLine().toUpperCase());
            barn.anotherWeekPassed(weekState);
        }

        System.out.println(barn.getState());
    }
}
