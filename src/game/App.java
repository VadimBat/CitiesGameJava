package game;

import game.action.GameLoop;
import game.action.GameRunner;
import game.action.Loopable;

public class App {
    public static void main(String[] args) {
        new GameRunner().startNewGame();
    }
}