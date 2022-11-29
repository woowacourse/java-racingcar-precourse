package racingcar.model;

import java.util.List;

public class winningResult {

    public int winnigScore(List<Car> cars){
        int max = 0;
        for(int m=0; m<cars.size(); m++){
            if (max<cars.get(m).getPosition()){
                max = cars.get(m).getPosition();
            }
        }
        return max;
    }

}
