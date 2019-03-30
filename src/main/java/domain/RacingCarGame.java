package domain;

public class RacingCarGame {
    private Car[] cars;
    private int maxPosition = 0;

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
            this.cars[i].printCarPosition(isMovePosition());
        }
        System.out.println();
    }

    public void setMaxPosition() {
        for (int i = 0; i < cars.length; i++) {
            this.maxPosition = cars[i].collectMaxPosition(maxPosition);
        }
    }
}