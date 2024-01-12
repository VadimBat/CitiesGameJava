package game.action;

import game.fill.Filler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCity implements Randomable{
    private static final String dataBase = "src/game/data/UkraineCitiesDataBase.txt";

    @Override
    public String getRandom(char firstChar) {
        List<String> cities = new Filler().fill(new File(dataBase));
        List<String> properCities = new ArrayList<>();
        for (String city : cities) {
            if (Character.toLowerCase(city.charAt(0)) == firstChar) {
                properCities.add(city);
            }
        }
        Random random = new Random();
        int index = random.nextInt(properCities.size());
        return properCities.get(index);
    }
}
