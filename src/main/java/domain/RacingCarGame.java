package domain;

public class RacingCarGame {
    private Car[] cars;

    public RacingCarGame(String cars) {
        registerCar(cars);
    }

    private void registerCar(String carsName) {
        String[] divCarsName = carsName.split(",");

        this.cars = new Car[divCarsName.length];
        for (int i = 0; i < divCarsName.length; i++) {
            this.cars[i] = new Car(divCarsName[i]);
        }
    }

    private boolean isMovePosition() {
        int randomNumber = (int) (Math.random() * 10);
        return ((randomNumber >= 4) ? true : false);
    }

    public void startRacingGame() {
        for (int i = 0; i < this.cars.length; i++) {
        }
        System.out.println();
    }
}