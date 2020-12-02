package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String WINNER_TEXT="최종 우승자: ";
    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars=new ArrayList<>(cars);
    }

    public void go(){
        cars.stream()
                .filter(car->car.isSatisfiedByNumber(RandomNumberGenerator.generate()))
                .forEach(Car::move);
    }

    public void printWinner(){
        System.out.print(WINNER_TEXT);
        StringBuilder sb=new StringBuilder();
        List<Car> sortedCars=cars.stream().sorted().collect(Collectors.toList());
        Car farthestCar=sortedCars.get(0);
        for(int i=0;i<sortedCars.size();i++){
            if(sortedCars.get(i).getPosition()!=farthestCar.getPosition())break;
            sb.append(sortedCars.get(i).getName()).append(", ");
        }
        System.out.println(sb.toString().substring(0,sb.length()-2));
    }

    public void printAllCarPosition(){
        cars.forEach(Car::printCurrentPosition);
        System.out.println();
    }
}
