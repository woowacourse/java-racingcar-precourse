package racingcar.view;

import racingcar.message.outputMessage;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class outputView {

    public void round(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void result(List<Car> cars, int firstPrize) {
        System.out.print(outputMessage.GAME_RESULT);
        List<String> winner = new ArrayList<>();
        for(int n=0; n<cars.size(); n++){
            if(cars.get(n).getPosition() == firstPrize) {
                winner.add(cars.get(n).getName());
            }
        }
        System.out.println(String.join(", ",winner));
    }
}
