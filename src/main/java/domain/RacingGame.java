package domain;

import java.util.ArrayList;

public class RacingGame {
    public static void main(String[] args) {
        UserIO io = new UserIO();
        String[] names = io.getName();          //  이름 입력
        int numberOfCar = names.length;
        int times = io.getTimes();              //  횟수 입력

        Car[] carArray = new Car[numberOfCar];  //  차량 목록 인스턴스화
        for (int i = 0; i < numberOfCar; i++) {
            carArray[i] = new Car(names[i]);
        }

        Score score = new Score();
        for (int i = 0; i < times; i++) {
            score.calcScore(numberOfCar, carArray);     //  점수 계산
            io.printIteration(carArray);                //  결과 출력
        }

        io.printWinner(score.calcWinner(carArray));     //  우승자 계산
    }
}
