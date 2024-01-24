package com.game.action;

import com.game.data.DataPath;
import com.game.fill.Filler;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameLoop implements Loopable {
    private int score = 0;
    private String lastComputerCity = null;
    private Randomable randomCity = new RandomCity();
    private List<String> cities = new Filler()
            .fill(new File(DataPath.UKRAINIAN_CITIES_PATH));

    private List<Character> exceptionChars = Arrays
            .asList('и', 'ї', 'й', 'ц', 'ь', 'ъ');

    @Override
    public void loop(Scanner scanner) {

        System.out.println("Lets start the game! Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your city to start:");

        while (true) {

            String input = scanner.nextLine();
            checkExit(input, name, score);

            // Check is list contains entered city by user
            boolean isCorrectCity = false;
            for (String city : cities) {
                if (city.equalsIgnoreCase(input)) {
                    isCorrectCity = true;
                    score++;
                    break;
                }
            }

            //Print wrong city
            if (!isCorrectCity) {
                System.out.println("Such city does not exist in the database. Please enter another city!");
                score--;
                continue;
            }

            // Check is the first letter correct
            if (lastComputerCity != null) {
                char lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length() - 1);
                for (Character exceptionChar : exceptionChars){
                    if (lastComputerCityChar == exceptionChar){
                        lastComputerCityChar = lastComputerCity.charAt(lastComputerCity.length() - 2);
                    }
                }
                char firstInputChar = input.charAt(0);

                if (Character.toLowerCase(lastComputerCityChar) != Character.toLowerCase(firstInputChar)) {
                    System.out.println("You entered city with incorrect first letter");
                    score--;
                    continue;
                }
            }

            printCity(input);
        }
    }

    //Check exit
    private void checkExit(String input, String name, int score) {
        if (input.equals("exit")) {
            System.out.println("Thank you! Hope it was nice game!");
            System.out.println("Your username: " + name);
            System.out.println("Your score: " + score);
            System.exit(0);
        }
    }

    //Check is the last symbol acceptable for continue or need use before last
    private char getLastChar(String input) {
        boolean isExceptionChar = true;
        for (int i = input.length() - 1; isExceptionChar; ) {
            isExceptionChar = false;
            for (Character exceptionChar : exceptionChars) {
                if (Character.toLowerCase(input.charAt(i)) == exceptionChar) {
                    isExceptionChar = true;
                    i--;
                    break;
                }
            }
            if (!isExceptionChar) {
                return input.charAt(i);
            }
        }
        return input.charAt(input.length() - 1);
    }

    //Print computer city
    private void printCity(String input) {
        char lastChar = getLastChar(input);
        lastComputerCity = randomCity.getRandom(lastChar);
        System.out.println("My city:" + lastComputerCity);
    }
}
