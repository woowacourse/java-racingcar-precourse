package racingcar.view;

import racingcar.message.outputMessage;
import racingcar.model.Car;

import java.util.List;

public class outputView {

    public void round(List<Car> cars) {
        for(Car car : cars) {
            //out(outputMessage.GAME_ROUND);
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

}
