package domain;
import java.util.Scanner;

public class RacingCar {
    public int maxPosition = 0;

    public static void main(String[] args) {
        RacingCar race = new RacingCar();
        race.play();
    }

    public void play() {
    }

    public String[] setCarNames() {
        Scanner scan = new Scanner(System.in);
        String[] carNames;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String userInput = scan.nextLine();
            carNames = userInput.split(",");
        } while (!areValidNames(carNames));
        return carNames;
    }

    public boolean areValidNames(String[] carNames) {
    }

    public Car[] makeCars(String[] carNames) {
    }

    public int setNumOfGames() {
    }

    public void doGame(Car[] cars) {
    }

    public void decideWinner(Car[] cars) {
    }
}
