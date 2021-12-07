package racingcar;

import java.util.List;

public class OutputManager {
    public void printCurrentCarPosition(Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private String getPositionString(int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printWinnerNames(List<String> winnerNames) {
        String joinedWinnerNames = String.join(", ", winnerNames);
        System.out.printf("최종 우승자 : %s%n", joinedWinnerNames);
    }

    public void printRoundSplitter() {
        System.out.println();
    }
}
