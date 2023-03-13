package racingcar.Domain;

public class CarGame {
    private Cars cars ;
    public CarGame(Cars cars){
        this.cars = cars;
    }

    public void playRound() {
        cars.move();
    }

    public Cars getCars() {
        return this.cars;
    }
}
