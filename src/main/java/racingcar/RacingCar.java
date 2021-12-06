package racingcar;

public class RacingCar {

    protected void startGame() {
        String[] carNameArray = UserInput.inputCarName();
        int numberOfAttempt = UserInput.inputNumberOfAttempts();

        for(String carName : carNameArray) {
            System.out.println(carName);
        }

        System.out.println("시도 횟수 : " + numberOfAttempt);
    }
}
