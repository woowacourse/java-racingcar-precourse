package racingcar.model;

import java.util.List;

public class winningResult {
    public int winningScore = 0;
    public void winnigScore(List<Car> cars){
        for(int m=0; m<cars.size(); m++){
            if (winningScore<cars.get(m).getPosition()){
                winningScore = cars.get(m).getPosition();
            }
        }
    }

}
