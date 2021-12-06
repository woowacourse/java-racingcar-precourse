package racingcar;

public class RacingCar {

    private Car[] carArray;

    protected void startGame() {
        createCarArray(UserInput.inputCarName());
        int numberOfAttempt = UserInput.inputNumberOfAttempts();

        for(int attempts = 0; attempts < numberOfAttempt; attempts++) {
            for(Car carIndex : carArray) {
                carIndex.moveCar();
                carIndex.printCarPosition();
            }
            System.out.println("");
        }
    }

    private void createCarArray(String[] carNameArray) {
        carArray = new Car[carNameArray.length];

        for(int i = 0; i < carNameArray.length; i++) {
            carArray[i] = new Car(carNameArray[i]);
        }
    }

}
