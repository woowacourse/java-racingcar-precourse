import domain.Car;

import static domain.Car.*;

public class RacingGame {
    public static void main(String[] args){

        int moveNumber = 0;                                                     // 이동 횟수 저장
        String[] getRacingCarNameArray = divideCarName(getCarName());
        Car[] racingCar = new Car[getRacingCarNameArray.length];

        racingCar = inputCarName(getRacingCarNameArray);
        moveNumber = getRacingCarMove();

        for(int i = moveNumber; i>0; i--){

            if(i == moveNumber){

                /* showResult 를 한번만 출력하기 위한 조건건*/
               showResult();
            }
            /* 입력받은 반복 횟수 만큼 반복*/
            saveDuringRacing(racingCar);
            showDuringRace(racingCar);
        }

        showWinner(racingCar,setFinalWinnerCarName(racingCar),
                   showWinnerSize(racingCar,setFinalWinnerCarName(racingCar)));
    }
}
