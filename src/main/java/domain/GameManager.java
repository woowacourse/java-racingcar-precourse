package domain;

import java.util.*;

public class GameManager {

    public int numOfCars;
    public int numOfRounds;
    public int randomRange;
    public String delimiter;
    public Car[] cars;

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.startGame();
        game.delimiter = ",";
        game.randomRange = 10;

        for (int i = 0; i < game.numOfRounds; i++) {
            System.out.println("실행결과");
            game.playGame();
        }
        game.printFinalWinner();
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
        int inputNumOfRounds = sc.nextInt();
        return inputNumOfRounds;
    }

    void playGame() {
        for (int carNum = 0; carNum < numOfCars; i++) {
            int randomNumber = getRandomNumber();
            checkGoStop(carNum, randomNumber);
            printCurrentPosition(carNum);
        }
    }

    int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(randomRange);
    }

    void checkGoStop(int carNum, int randomNumber) {
        if (randomNumber >= 4) {
            cars[carNum].go();
            return;
        }
        if (randomNumber <= 3) {
            cars[carNum].stop();
            return;
        }
    }

    void printCurrentPosition(int carNum) {
        cars[carNum].printName();
        cars[carNum].printPosition();
        System.out.println();
    }

    void printFinalWinner() {
        ArrayList<Integer> finalPositionArray = new ArrayList<Integer>();
        for (int i = 0; i < numOfCars; i++) {
            finalPositionArray.add(cars[i].getPosition());
        }
        int maxPosition = Collections.max(finalPositionArray);

        for (int i = 0; i < numOfCars; i++) {
            if(cars[i].getPosition() == maxPosition){
                System.out.print(cars[i].getName() + ",");
            }
        }
        System.out.print("가 최종 우승했습니다.");
    }
}
