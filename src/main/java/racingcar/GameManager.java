package racingcar;

import java.util.ArrayList;

public class GameManager {

    private int numberOfTry = 0;
    private ArrayList<Car> carList = new ArrayList<>();

    public GameManager(String[] names, int numberOfTry) {
        for (String name : names) {
            carList.add(new Car(name));
        }
        this.numberOfTry = numberOfTry;
    }

    public void gameStart() {
        // 랜덤값 받아오기

        // Game Start
        // 하나의 라운드 별로 numberOfTry만큼 반복 수행
        
        /* 입력 값들 예외처리 후 받아오기 완료.

         * <앞으로 해야할 일>
         * 1. Game Round 별로 Game play 
         * 2. Random값 받아와서 forwardPosition() 수행
         * 3. 하드코딩 된 부분 찾아서 상수화(static final) 시키기
         * 4. AskQuestion.java를 분할하고 싶다 !!!!!
         * 5. 변수명에 불용어 찾아보고 대체하기
         * 6. README에 예외 상황 추가 및 input/output 관련된 내용은 삭제해야 하나..?
         */

        System.out.println("===== 입력된 시도 회수 ===== : " + numberOfTry);

        System.out.println("===== 등록된 자동차 명단 =====");
        for (Car car : carList) {
            System.out.println(car.getName());
        }
    }

}
