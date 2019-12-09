import domain.Car;
import domain.RacingCars;
import domain.Winners;
import utils.InputUtil;
import utils.OutPutUtil;

public class RacingCarGame {

    public static void start() {
        Referee referee = new Referee();
        OutPutUtil.printRacingCarsNameDemand();
        // TODO : 리펙토링 함수를 따로 하나 더 빼서 구현할지 생성자로 구현할지 결정
        // TODO : Java 컨벤션 객체 선언 위치 수정 리팩토링 필요
        RacingCars racingCars = new RacingCars(InputUtil.inputRacingCars());

        OutPutUtil.askAttempTime();
        Integer count = InputUtil.inputCount();

        while (count-- > 0) {
            racingCars.move();
        }

        // TODO : Java 컨벤션 객체 선언 위치 수정 리팩토링 필요
        Winners winners = new Winners(referee.decideWinners(racingCars.getRacingCars()));
        for(int i = 0 ; i < winners.getWinners().size(); i++){
            System.out.println(winners.getWinners().get(i).getCarOriginName());
        }
        
        OutPutUtil.printWinners(winners);
    }
}
