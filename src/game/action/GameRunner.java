package game.action;

public class GameRunner {
    private Loopable game = new GameLoop();
    public void startNewGame(){
        game.loop();
    }
}
