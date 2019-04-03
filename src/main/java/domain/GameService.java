package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class GameService {

    private final Console console;

    GameService(){
        console = new Console();
    }

    List<Car> getCarList() throws IOException{
        String[] cars = getCars();
        List<Car> carList = new ArrayList<>();

        for (String carName : cars){
            carList.add(new Car(carName));
        }

        return carList;
    }

    private String[] getCars() throws IOException {
        return console.readCars().split(",");
    }

    int getRoundCount() throws IOException{
        return console.readRoundCount();
    }

    void roundStart(){
        console.writeRoundStartMessage();
    }

    void setRoundResult(List<Car> carList){
        console.writeRoundResult(carList);
    }

    void makeWinnerList(List<Car> carList){
        int max = maxPosition(carList);

        console.writeGameResult(carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList()));
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
