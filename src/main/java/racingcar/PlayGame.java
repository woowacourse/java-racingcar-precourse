package racingcar;

import java.util.ArrayList;

public class PlayGame {
    Computer computer;
    User user;
    String[] carString;
    Integer playNum;
    ArrayList <Car> cars = new ArrayList<>();

    public void Play(){
        initSetting();
        CarName();
        PlayNum();
        Race();
        WinPerson();
    }

    //초기 세팅 함수
    private void initSetting(){
        computer = new Computer();
        user = new User();
    }
    
    //자동차 이름 입력 함수
    private void CarName(){
        computer.MSGCarName();
        carString = user.InputCarName();
        CarList();
    }

    // stringq 배열을 Car 객체 ArrayList로 변경
    private void CarList(){
        for(String car : carString){
            Car c = new Car(car);
            cars.add(c);
        }
    }

    // 시도 횟수 입력
    private void PlayNum(){
        computer.MSGPlayNum();
        playNum = user.InputPlayNum();
        System.out.println();
    }

    private void Race(){
        System.out.println("실행 결과");
        for(int i=0; i<playNum; i++){
            for(Car car : cars){
                car.CarPlay();
            }
            System.out.println();
        }
    }

    private void WinPerson(){
        int maxNum = 0;
        for(Car car : cars) {
            maxNum = Math.max(maxNum, car.getPosition());
        }
        isMaxPosition(maxNum);
    }

    private void isMaxPosition(int maxNum) {
        boolean comma = false;
        System.out.print("최종 우승자 : ");
        for(Car car : cars){
            if(car.getPosition() == maxNum){
                PrintWinPerson(comma, car);
                comma = true;
            }
        }
    }

    private void PrintWinPerson(boolean comma, Car car) {
        if (comma) {
            System.out.print(", " + car.getName());
        }
        if (!comma) {
            System.out.print(car.getName());
        }
    }

}
