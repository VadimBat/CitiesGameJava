package com.game.fill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filler implements Fillable {
    private List<String> base = new ArrayList<>();
    @Override
    public List<String> fill(File file) {
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                base.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
       return base;
    }
}
