package racingcar;

public class GameManager {
    private static GameManager instance = null;

    public static GameManager getInstance() {
        if(GameManager.instance == null) {
            GameManager.instance = new GameManager();
        }

        return GameManager.instance;
    }

    private GameManager(){}

    public void run() {

    }
}
