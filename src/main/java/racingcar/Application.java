package racingcar;

public class Application {
    public static void main(String[] args) {
        CarListMaker carList = new CarListMaker();  // 자동차 리스트 생성
        RepeatNumMaker repeatNum = new RepeatNumMaker(); // 숫자 생성
        Race race = new Race(carList.getCarList(), repeatNum.getRepeatNum()); // 레이스 돌리기
        // race.getCarList(); // 우승 결과 출력
    }
}
