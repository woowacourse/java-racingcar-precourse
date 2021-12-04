package racingcar;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        GameController gameController = new GameController(view, model);
        
        gameController.playGame();
    }
}
