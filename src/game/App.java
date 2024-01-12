package game;

import game.action.GameLoop;
import game.action.Loopable;

public class App {
    private static final String dataBase = "src/game/data/UkraineCitiesDataBase.txt";
    public static void main(String[] args) {
        Loopable game = new GameLoop();
        game.loop();
    }
}