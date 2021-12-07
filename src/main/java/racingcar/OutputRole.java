package racingcar;

import java.util.ArrayList;

public class OutputRole {
    private static final String RESULT_INSTRUCTION = "실행 결과 ";
    private static final String MATCH_USER_AND_RESULT = " : ";
    private static final String PROGRESS_BAR_UNIT = "-";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COMMA = ", ";


    public void pirntResultInstruction() {
        System.out.println();
        System.out.println(RESULT_INSTRUCTION);
    }

    public void printOneGame(ArrayList<Car> carList) {
        for (Car car : carList) {
            printFormattedResult(car);
            System.out.println();
        }
        System.out.println();

    }

    public void printWinner(ArrayList<String> winnersList) {
        System.out.print(FINAL_WINNER + MATCH_USER_AND_RESULT);
        String winners = "";
        for (String winner : winnersList) {
            winners = winners.concat(winner + COMMA);
        }
        System.out.print(winners.substring(0, winners.length() - 2));  // remove last comma


    }

    private void printFormattedResult(Car car) {
        String carName = car.getName();
        int position = car.getPosition();
        System.out.print(carName + MATCH_USER_AND_RESULT);
        printProgress(position);

    }

    private void printProgress(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(PROGRESS_BAR_UNIT);
        }
    }
}
