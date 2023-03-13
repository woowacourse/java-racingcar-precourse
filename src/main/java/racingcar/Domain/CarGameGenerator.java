package racingcar.Domain;

public class CarGameGenerator {

    public static CarGame makeCarGame(Cars cars){
        return new CarGame(cars);
    }
}
