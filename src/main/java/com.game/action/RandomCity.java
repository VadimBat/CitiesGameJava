package com.game.action;

import com.game.data.DataPath;
import com.game.fill.Filler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCity implements Randomable {

    private Random random = new Random();

    //Computer get random city from database
    @Override
    public String getRandom(char firstChar) {
        List<String> cities = new Filler().fill(new File(DataPath.UKRAINIAN_CITIES_PATH));
        List<String> properCities = new ArrayList<>();
        for (String city : cities) {
            if (Character.toLowerCase(city.charAt(0)) == firstChar) {
                properCities.add(city);
            }
        }
        int index = random.nextInt(properCities.size());
        return properCities.get(index);
    }
}
