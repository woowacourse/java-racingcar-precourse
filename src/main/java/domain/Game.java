package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Console console;

    Game(){
        console = new Console();
    }

    public void play() throws IOException {

        List<Car> carList = makeCarList(getCars());
        int roundCount = getRoundCount();

        for (int i = 0; i < roundCount; i++) {
            round(carList);
        }

        endGame(makeWinnerList(carList));
    }

    private List<Car> makeCarList(String[] cars){
        List<Car> carList = new ArrayList<>();

        for (String carName : cars){
            carList.add(new Car(carName));
        }

        return carList;
    }

    private String[] getCars() throws IOException {
        return console.readCars().split(",");
    }

    private int getRoundCount() throws IOException{
        return console.readRoundCount();
    }

    private void round(List<Car> carList){
        for (Car car : carList){
            car.move(moveOrNot());
        }
        console.writeRoundResult(carList);
    }

    private int moveOrNot(){
        return (int)(Math.random()*10) > 3 ? 1 : 0;
    }

    private void endGame(List<String> winnerList){
        console.writeGameResult(winnerList);
    }

    private List<String> makeWinnerList(List<Car> carList){
        int max = maxPosition(carList);

        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition(List<Car> carList){
        int max = 0;

        for (Car car : carList){
            if (max < car.getPosition()){
                max = car.getPosition();
            }
        }

        return max;
    }
}
