package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {

    private Car car [];
    private int times;

    public Racing() {
        car = Car.getCarName();
        doGame();
        //Car 객체배열 리턴후 doGame 호출
    }

    public void getTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        times = Integer.parseInt(Console.readLine());
    }

    public void doGame() {
        for (Car car : car) {
            if (Utils.exceedMoveForwardScoreOrNot(Utils.getRandomNumber())) {
                car.move();
                //각 줄을 print하는 기능 추가
            }
        }
    }
}
