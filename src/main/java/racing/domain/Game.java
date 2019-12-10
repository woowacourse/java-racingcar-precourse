package racing.domain;

public class Game {
    public static Game getInstance(CarList cars, CarRunRule runRule) {
        return null;
    }

    public void start(int round) {
        for (int i = 0; i < round; i++) {
            playOneRound();
            printCarStatus();
        }
    }

    private void playOneRound() {

    }

    private void printCarStatus() {

    }

    public Winner getWinners() {
        return null;
    }
}
