
import Entities.WeekState;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Barn barn = WelcomeMenu.printWelcomeMenuAndReturnBarn(scanner);
        System.out.println("For how many week you'd like to run the simulation");
        int weeksToRun = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < weeksToRun; i++) {
            System.out.println("Enter the type of the week");
            WeekState weekState = WeekState.valueOf(scanner.nextLine().toUpperCase());
            barn.anotherWeekPassed(weekState);
        }

        System.out.println(barn.getState());

        String result = FileSaveMenu.run(scanner, barn);
        System.out.println(result);
    }
}
