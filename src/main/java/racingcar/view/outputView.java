package racingcar.view;

import racingcar.message.outputMessage;
import racingcar.model.Car;

import java.util.List;

public class outputView {

    public void round(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    public void result(List<Car> cars, int firstPrize) {
        System.out.print("최종 우승자 : ");
        int cnt = 0;
        for(int n=0; n<cars.size(); n++){
            if(cars.get(n).getPosition() == firstPrize) {
                if(cnt==0){
                    System.out.print(cars.get(n).getName());
                } else {
                    System.out.print(", "+cars.get(n).getName());
                }
            }
        }
    }

}
