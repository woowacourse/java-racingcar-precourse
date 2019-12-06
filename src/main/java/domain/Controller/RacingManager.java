package domain.Controller;

import domain.Model.Car;

public class RacingManager {
    private InputManager inputmanager;
    private String[] carNamesArray;
    private int numberOfLaps;


    public RacingManager() {
        inputmanager = new InputManager();
    }

    private String[] splitCarNames(String carNames,
                                   String divideStandard) {
        return carNames.split(divideStandard);
    }

    public boolean namesLengthGraterThanFive
            (String[] splitedCarNames) {
        for (String carName : splitedCarNames) {
            if (carName.length() > 5) {
                System.out.println("자동차 이름을 5자 이하로 입력하세요!!");
                return true;
            }
        }
        return false;
    }

    public void runOrStop(int numberOfLaps, int iterationNumber, Car cars[]) {
        for (int i = 0; i < iterationNumber; i++) {
            for (int j = 0; j < iterationNumber; j++) {
                cars[j].canYouGo();
                System.out.println(cars[j].getName()
                        + " : " + cars[j].getPosition());
            }
            System.out.println();
        }
    }

    public void whoIsWinner(int numberOfCars, int maxPosition, Car[] cars) {
        System.out.print("<< ");
        for (int i = 0; i < numberOfCars; i++) {
            if (cars[i].getPosition() == maxPosition) {
                System.out.print(cars[i].getName() + " ");
            }
        }
        System.out.println(">> 최종 우승!!");
    }

    private void carSetting() {
        do {
            this.carNamesArray = inputmanager.inputCarNamesArray();
        } while (namesLengthGraterThanFive(carNamesArray));
    }

    private void lapSetting() {
        this.numberOfLaps = inputmanager.inputNumberOfLaps();
    }

    public void start() {
        carSetting();
        lapSetting();
    }
}
