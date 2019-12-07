package domain;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Race 객체는 Car 객체의 리스트를 가지고,
 * Car들의 경주를 실행하고 그 결과를 출력해준다.
 * 상위 객체를 통해 startRace 명령을 받아 수행된다.
 * @author kafka
 * @version 1.0
 */
public class Race {

    /** STRING_END_OF_RACE 는 상수형 String 객체로, 레이스 종료시 승자의 이름과 함꼐 출력될 값이다. */
    private static final String STRING_END_OF_RACE = "가 최종 우승했습니다";

    /** STRING_ASK_REPEAT 는 상수형 String 객체로, 반복횟수 입력 전에 출력된다. */
    private static final String STRING_ASK_REPEAT = "시도할 횟수는 몇회인가요?";

    /** STRING_ASK_NAME 은 상수형 String 객체로, 이름 입력 전에 출력된다. */
    private static final String STRING_ASK_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";

    /** STRING_INPUT_ERROR 는 상수형 String 객체로, 입력 과정에 에러 발생시 출력된다. */
    private static final String STRING_INPUT_ERROR = "잘못된 값을 입력하셨습니다.";

    /** STRING_SPLIT_NAME 은 상수형 String 객체로, 이름을 서로 구분하는 구분자를 저장한다. */
    private static final String STRING_SPLIT_NAME = ",";

    /** carList : 자동차 객체를 저장하는 리스트이다. */
    List<Car> carList;

    /** raceRepeat : 레이스 반복 횟수를 저장하는 int형 정수이다.*/
    private int raceRepeat;

    /** maxRaceRecode : 레이스의 최대 거리 기록을 저장하는 int형 정수이다. */
    private int maxRaceRecode;

    /**
     * accletateCarList는 carList 안에 있는 Car 객체들에 대하여,
     * 각자 가속하도록 accelerateCar 메서드를 호출해주는 메서드이다.
     * 또한 이 값을 makeRaceRecod 메서드에 파라미터로 보내, 최고 기록을 경신해준다.
     */
    private void accelerateCarList() {
        for(Car i : carList){
            makeRaceRecode(i.accelerateCar());
        }
    }

    /**
     * makeRaceRecode는 자동차가 가속될때마다 같이 호출된다.
     * 가속한 자동차의 기록을 받아, 지금까지 제일 앞서나가는 자동차의 위치를 저장한다.
     * @param carPosition : 자동차의 위치를 전달해주는 int형 정수
     */
    private void makeRaceRecode(int carPosition) {
        if(carPosition > maxRaceRecode) {
            maxRaceRecode = carPosition;
        }
    }

    /**
     * getRaceWinner 메서드는 경주가 끝난 레이스에 대하여
     * 경주 결과를 리턴해주는 메서드이다.
     * @return 출력할 String형의 결과값
     */
    private String getRaceWinnerToString() {
        String winnerMessage="";

        for(Car i : carList) {
            if(i.getPosition() == maxRaceRecode) {
                winnerMessage += i.getName();
            }
        }
        winnerMessage += STRING_END_OF_RACE;
        return winnerMessage;
    }

    /**
     *
     * @param nameString
     * @return
     */
    private List<String> splitNameString(String nameString){

    }

    /**
     * getNameToInput은 하나의 문자열 입력을 받아,
     * 그 문자열을 여러 개의 이름 블록으로 분리하여 리스트로 만든다.
     * @return 이름의 목록을 String형 List로 리턴해준다.
     */
    private List<String> getNameToInput() {
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.println(STRING_ASK_NAME);
        try{
            inputString = sc.nextLine();
        } catch(InputMismatchException e){
            System.out.println(STRING_INPUT_ERROR);
            return getNameToInput();
        }
        inputString.split(STRING_SPLIT_NAME);
    }

    /**
     * getRepeatToInput은 경주의 반복 횟수를 입력받아 리턴하는 메서드이다.
     * 예외처리 : 잘못된 값이 들어오면 에러 메세지를 출력하고, 자기 자신을 리턴해준다.
     * 이를 통해 재귀적으로 올바른 값을 돌려준다.
     * @return int형의 경기 횟수를 리턴해준다.
     */
    private int getRepeatToInput() {
        Scanner sc = new Scanner(System.in);
        int inputNumber;

        System.out.println(STRING_ASK_REPEAT);
        try {
            inputNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            inputNumber = 0;
        }

        if(inputNumber <= 0) {
            System.out.println(STRING_INPUT_ERROR);
            return getRepeatToInput();
        }
        return inputNumber;
    }

    /**
     * Race는 생성자 메서드로, 자동차 이름과 댓수, 경기의 횟수를 저장한다.
     * 자동차 이름은 getNameToInput 메서드를 통해 만들어 저장한다.
     * 경기 횟수는 getRepeatToInput 메서드를 통해 만들어 저장한다.
     * 이후 자동차 객체를 만들어 이름을 생성자로 전달한다.
     */
    public Race() {
        List<String> carNameList = getNameToInput();
        this.raceRepeat = getRepeatToInput();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
        maxRaceRecode = 0;
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
        System.out.println(getRaceWinnerToString());
    }
}