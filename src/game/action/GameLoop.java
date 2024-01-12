package game.action;

import game.fill.Filler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLoop implements Loopable{
    private static final String dataBase = "src/game/data/UkraineCitiesDataBase.txt";
    private String lastComputerCity = null;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void loop() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Thank you! Hope it was nice game!");
                System.exit(0);
            }
            List<String> cities = new Filler().fill(new File(dataBase));

            // Check is list contains entered city by user
            boolean isCorrectCity = false;
            for (String city : cities) {
                if (city.equalsIgnoreCase(input)) {
                    isCorrectCity = true;
                    break;
                }
            }

            if (!isCorrectCity) {
                System.out.println("Such city does not exist in the database. Please enter another city!");
                continue;
            }

            // Check is the first letter correct
            if (lastComputerCity != null) {
                char lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length() - 1);
                char firstInputChar = input.charAt(0);

                if (Character.toLowerCase(lastComputerCityChar) != Character.toLowerCase(firstInputChar)) {
                    System.out.println("You entered city with incorrect first letter");
                    continue;
                }
            }

            Randomable randomCity = new RandomCity();
            char lastChar = input.charAt(input.length() - 1);
            lastComputerCity = randomCity.getRandom(lastChar);
            System.out.println("My city:" + lastComputerCity);
        }
    }
}
