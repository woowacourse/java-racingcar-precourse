package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    private List<Car> lineup;
    List<String> winners;

    public Racing() {
        this.lineup = new ArrayList<>();
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] waitingCarNames = Console.readLine().split(",");
        enroll(waitingCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        Integer repeatTimes = getRepeatTimes();

        System.out.println("실행 결과");
        race(repeatTimes);
        callWinner();
    }

    private void enroll(String[] waitingCarNames) {
        for (int i = 0; i < waitingCarNames.length; i++) {
            String carName = waitingCarNames[i].trim();
            try {
                validateCarName(carName);
                Car car = new Car(carName);
                lineup.add(car);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                this.lineup = new ArrayList<>();
                String[] retriedWaitingCarNames = Console.readLine().split(",");
                enroll(retriedWaitingCarNames);
            }
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이가 5를 넘습니다");
        }
    }

    private Integer getRepeatTimes() {
        String rawRepeatTimes = Console.readLine();
        try {
            Integer repeatTimes = convertToNumber(rawRepeatTimes);
            validateRepeatTimes(repeatTimes);
            return repeatTimes;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("다시 입력해주세요.");
            return getRepeatTimes();
        }
    }

    private Integer convertToNumber(String rawRepeatTimes) {
        try {
            return Integer.parseInt(rawRepeatTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    private void validateRepeatTimes(Integer repeatTimes) {
        if (repeatTimes <= 0) {
            throw new IllegalArgumentException("[ERROR] 1 이상의 수를 입력해야 합니다");
        }
    }

    private void race(Integer repeatTimes) {
        int round = 0;
        while (round < repeatTimes) {
            for (Car car : lineup) {
                car.goOrStop();
            }
            for (Car car : lineup) {
                int position = car.getPosition();
                System.out.println(car.getName() + " : " + String.join("", Collections.nCopies(position, "-")));
            }
            System.out.println();
            round++;
        }
    }

    private void callWinner() {
        winners = new ArrayList<>();
        findWinner();
        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");
        for (String leader : winners) {
            stringBuilder.append(leader).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }

    private void findWinner() {
        int leaderPosition = -1;
        for (Car participantCar : lineup) {
            int position = participantCar.getPosition();
            String name = participantCar.getName();
            leaderPosition = calculatePosition(leaderPosition, position, name);
        }
    }

    private int calculatePosition(int leaderPosition, int position, String name) {
        if (leaderPosition < position) {
            leaderPosition = position;
            winners.clear();
            winners.add(name);
        } else if (leaderPosition == position) {
            winners.add(name);
        }
        return leaderPosition;
    }
}
