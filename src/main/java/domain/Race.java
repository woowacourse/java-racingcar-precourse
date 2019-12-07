package domain;

import java.util.List;
import java.util.ArrayList;

/**
 * Race 객체는 Car 객체의 리스트를 가지고,
 * Car들의 경주를 실행하고 그 결과를 출력해준다.
 * 상위 객체를 통해 startRace 명령을 받아 수행된다.
 * @author kafka
 * @version 1.0
 */
public class Race {

    /** STRING_END_OF_RACE 는 상수형으로, 레이스 종료시 승자의 이름과 함꼐 출력될 값이다. */
    private static final String STRING_END_OF_RACE = "가 최종 우승했습니다";

    /** carList : 자동차 객체를 저장하는 리스트이다. */
    List<Car> carList;

    /** raceRepeat : 레이스 반복 횟수를 저장하는 int형 정수이다.*/
    private int raceRepeat;

    /**
     * Race는 생성자 메서드로, 자동차 이름과 댓수, 경기의 횟수를 저장한다.
     * 자동차 이름은 getNameToInput 메서드를 통해 만들어 저장한다.
     * 경기 횟수는 getRepeatToInput 메서드를 통해 만들어 저장한다.
     * 이후 자동차 객체를 만들어 이름을 생성자로 전달한다.
     */
    public Race(){
        List<String> carNameList = getNameToInput();
        this.raceRepeat = getRepeatToInput();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
    }

    /**
     * raceStart는 상위 객체에서 레이스 시작을 조작할 수 있도록 만든 public 메서드이다.
     * 메서드가 호출되면, 입력받은 repeat값과 미리 생성한 car객체를 통해
     * 레이스를 벌이고, 이에 대한 승자값을 출력해 준다.
     *
     * 만약 레이스가 여러 번 벌어질 경우, raceStart에서 초기화 작업을 해줄 필요가 있다.
     * (Car 객체 내부에 초기화 메서드를 만들어 호출하는 방식)
     * 그러나 본 프로젝트에서는 여러 번의 경주를 가정하지 않으므로,
     * 이 기능은 별도 구현하지 않았다.
     */
    public void raceStart(){
        for(int i = 0; i < raceRepeat; i++) {
            accelerateCarList();
        }
        System.out.println(getRaceWinner());
    }

    /**
     * accletateCarList는 carList 안에 있는 Car 객체들에 대하여,
     * 각자 가속하도록 accelerateCar 메서드를 호출해주는 메서드이다.
     */
    private void accelerateCarList() {
        for(Car i : carList){
            i.accelerateCar();
        }
    }

    /**
     * getRaceWinner 메서드는 경주가 끝난 레이스에 대하여
     * 경주 결과를 리턴해주는 메서드이다.
     * @return 출력할 String형의 결과값
     */
    private String getRaceWinner() {

    }

    /**
     *
     * @return
     */
    private List<String> getNameToInput() {

    }

    /**
     *
     * @param nameString
     * @return
     */
    private List<String> splitNameString(String nameString){

    }

    /**
     *
     * @return
     */
    private int getRepeatToInput(){
        int inputNumber;
        return inputNumber;
    }
}