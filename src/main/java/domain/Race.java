package domain;

import java.util.List;
import java.util.ArrayList;

public class Race {
    /*carList : 자동차 객체를 저장하는 리스트이다.*/
    List<Car> carList;
    /*raceRepeat : 레이스 반복 횟수를 저장하는 int형 정수이다.*/
    int raceRepeat;
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
     *
     */
    public void raceStart(){

    }

    /**
     *
     * @return
     */
    private List<String> getNameToInput() {

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