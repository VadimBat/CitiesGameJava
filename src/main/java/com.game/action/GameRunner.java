package com.game.action;

import java.util.Scanner;

public class GameRunner {
    private Scanner scanner = new Scanner(System.in);
    private Loopable game = new GameLoop();
    public void startNewGame(){
        game.loop(scanner);
        scanner.close();
    }
}
