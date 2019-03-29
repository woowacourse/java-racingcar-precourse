package domain;

public class Main {
    public static void main(String[] args) {
        CarGame carGame = new CarGame();
        int runs = carGame.getRuns();

        carGame.printResultTitle();
        while(runs-- > 0) {
            carGame.printResultEachGame();
        }
    }
}
