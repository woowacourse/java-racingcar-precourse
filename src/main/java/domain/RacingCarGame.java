package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.startRacingCarGame();
    }

    private void startRacingCarGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> racingCars = getRacingCarName();
        System.out.println("시도 할 횟수는 몇번 인가요?");
        int racingLab = getRacingLab();
        racingGameCourse(racingCars, racingLab);
    }

    private void racingGameCourse(List<Car> racingCars, int racingLab) {
        for(int race = 0; race < racingLab; race++) {
            getEachLabCarState(racingCars);
        }
    }

    private void getEachLabCarState(List<Car> racingCars) {
        Random getCarState = new Random();
        for(int car = 0; car < racingCars.size(); car++) {
            if(getCarState.nextInt(9) > 3) {
                racingCars.get(car).moveForward();
            }
        }
    }

    private int getRacingLab() {
        Validator labValidator = new Validator();
        return labValidator.getRacingLab();
    }

    private List<Car> getRacingCarName() {
        Validator carValidator = new Validator();
        List<String> racingCarNames = carValidator.getRacingCarNames();
        List<Car> racingCars = new ArrayList<>();
        for(String racingCar : racingCarNames) {
            racingCars.add(new Car(racingCar));
        }
        return racingCars;
    }


}
