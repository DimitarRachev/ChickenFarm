import Exeptions.FileNotRecognizedException;
import Writers.BirdWriter;
import Writers.BirdWriterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSaveMenu {
    public static String run(Scanner scanner, Barn barn) {

        System.out.println("Would you like to save it to file? (Y/N): ");
        String line = scanner.nextLine().trim().toUpperCase();
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
                    return "File saved successfully in  : " + output.getAbsolutePath();
                } else {
                    return "There was a problem saving file at: " + output.getAbsolutePath();
                }
            } catch (FileNotFoundException | FileNotRecognizedException e) {
                return e.getMessage();
            }
        }
        return "There's an error in FileSaveMenu";

    }
}
