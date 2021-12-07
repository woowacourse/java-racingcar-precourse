package view;

import domain.Car;

import java.util.List;

public class OutputView {
    private final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printResultForOneGame(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + repeat("-", car.getPosition()));
        }

        System.out.println();
    }

    public void printFinalResult(List<String> winners) {
        if (winners.size() == 1) {
            printWinner(winners.get(0));
        }

        if (winners.size() > 1) {
            printWinners(winners);
        }
    }

    private void printWinner(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    private void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);

        StringBuilder sb = new StringBuilder();
        int len = winners.size();
        for (int i = 0; i < len; i++) {
            sb.append(winners.get(i));
            if (i != len - 1) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    private String repeat(String target, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(target);
        }
        return sb.toString();
    }
}
