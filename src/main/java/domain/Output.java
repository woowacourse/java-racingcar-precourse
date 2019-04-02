/*
 * 클래스 이름: Output.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/03
 * Copyright 2019 Inkwon Lee
 */
package domain;

import java.util.ArrayList;

/*
 * 출력문 담당 클래스
 * 게임 진행 상황을('-') 보는 함수 구현
 * 게임 승자를 출력해주는 함수 구현
 */
public class Output {

    static final String outputEnrollCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String outputTryNumber = "시도할 회수는 몇회인가요?";
    static final String outputOngoing = "실행 결과";
    static final String outputResult = "이(가) 최종 우승했습니다.";

    private Output() {
    }

    private static class OutputHolder {
        public static final Output INSTANCE = new Output();
    }

    public static Output getInstance() {
        return OutputHolder.INSTANCE;
    }

    public void gameOngoingMessage(Car car) {
        System.out.printf("%s : ", car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public StringBuilder gameRusultMessage(ArrayList<Car> carNameList) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> winnerList = new ArrayList<>();

        getWinner(winnerList, carNameList);

        for (int i = 0; i < winnerList.size() - 1; i++) {
            result.append(winnerList.get(i)).append(",");
        }
        result.append(winnerList.get(winnerList.size() - 1));

        return result;
    }

    private void getWinner(ArrayList<String> winnerList, ArrayList<Car> carNameList) {
        int max = -1;

        for (int i = 0; i < carNameList.size(); i++) {
            if (carNameList.get(i).getPosition() > max) { // max 보다 클경우 winnerList 전부 삭제하고 등록
                max = carNameList.get(i).getPosition();
                winnerList.clear();
                winnerList.add(carNameList.get(i).getName());
                continue;
            }

            if (carNameList.get(i).getPosition() == max) { // max 하고 같을경우 winnerList 에 add
                winnerList.add(carNameList.get(i).getName());
            }
        }
    }

}
