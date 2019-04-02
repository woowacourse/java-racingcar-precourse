import domain.Car;

import static domain.Car.*;

public class RacingGame {
    public static void main(String[] args){

        String getRacingCarName = getCarName();
        String[] getRacingCarNameArray = divideCarName(getRacingCarName);
        Car[] racingCar = new Car[getRacingCarNameArray.length];

        racingCar = inputCarName(getRacingCarNameArray);

        for(int i=getRacingCarMove();i>0;i--){

            /* 입력받은 반복 횟수 만큼 반복*/
            saveDuringRacing(racingCar);
            showDuringRace(racingCar);
        }

        showWinner(racingCar,setFinalWinnerCarName(racingCar),
                showWinnerSize(racingCar,setFinalWinnerCarName(racingCar)));
    }
}
