package domain.Controller;

import domain.Model.Car;

import java.util.Random;

public class RacingManager {
    private InputManager inputmanager;
    private CarManager carmanager;
    private Random random;
    private String[] carNamesArray;
    private int numberOfLaps;


    public RacingManager() {
        inputmanager = new InputManager();
        random = new Random();
    }

    private boolean isNamesLengthGraterThanFive
            (String[] splitedCarNames) {
        for (String carName : splitedCarNames) {
            if (carName.length() > 5) {
                System.out.println("자동차 이름을 5자 이하로 입력하세요!!");
                return true;
            }
        }
        return false;
    }

    private void moveOrStop(){
        for (int i = 0; i < numberOfLaps; i++) {
            for (int j = 0; j < carmanager.getCarsLength(); j++) {
                carmanager
                        .ifBiggerThanFourYouCanMove(random.nextInt(10), j);
            }
            printResultEachLap();
        }
    }

    private void printResultEachLap() {
        carmanager.printCarsNameAndPosition();
        System.out.println();
    }

    private void race() {
        moveOrStop();
        printResultEachLap();
    }

    private void printWinner() {
        carmanager.whoIsWinner();
    }

    private void carSetting() {
        do {
            this.carNamesArray = inputmanager.inputCarNamesArray();
        } while (isNamesLengthGraterThanFive(carNamesArray));
        carmanager = new CarManager(carNamesArray);
    }

    private void lapSetting() {
        this.numberOfLaps = inputmanager.inputNumberOfLaps();
    }

    public void start() {
        carSetting();
        lapSetting();
        race();
        printWinner();

    }
}
