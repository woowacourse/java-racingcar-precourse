package domain;

import java.util.ArrayList;

public class winnerPicker {
    public static ArrayList getWinner(){
        ArrayList<Car> list = new ArrayList<>();
        String result="";
        int winnerPoint = 0;
        for(Car car : CarRepository.carPark)
            winnerPoint = Math.max(winnerPoint,car.getPosition());
        for(Car car : CarRepository.carPark)
            if(car.getPosition() == winnerPoint) list.add(car);
        return list;
    }
}
