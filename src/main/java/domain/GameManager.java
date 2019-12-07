package domain;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GameManager {

    public int numOfCars;
    public int numOfRounds;
    public String delimiter;
    public Car[] cars;

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.startGame();

        while (true) {
            game.playGame();
        }
    }

    void startGame() {
        String carNames = getCarNames();
        setCarName(carNames);
        numOfRounds = getNumOfRounds();
    }

    String getCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        return carNames;
    }

    void setCarName(String input) {
        delimiter = ",";
        StringTokenizer token = new StringTokenizer(input, delimiter);
        numOfCars = token.countTokens();
        cars = new Car[numOfCars];

        for (int i = 0; i < numOfCars; i++) {
            String carName = token.nextToken();
            cars[i] = new Car(carName);
        }
    }

    int getNumOfRounds() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 얼마인가요?");
        return sc.nextInt();
    }

    void playGame() {

    }


}
