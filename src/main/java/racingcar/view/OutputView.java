package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_LOG_PREFIX = "[ERROR]";
    private static final String WINNER_LOG_BEGIN = "최종 우승자: ";
    private static final String AND_LOG = ", ";

    public static void printWinnerLog(List<Car> carList){
        int maxPosition = getMaxPosition(carList);
        List<Car> winners = getWinners(carList, maxPosition);
        String winnerLog = getWinnerLog(winners);
        System.out.println(winnerLog);
    }

    private static List<Car> getWinners(List<Car> carList, int maxPosition){
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> carList){
        int maxPosition = 0;
        for(Car car : carList){
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    private static String getWinnerLog(List<Car> winners){
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_LOG_BEGIN);
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i).getName());
            if(i != winners.size() -1){
                sb.append(AND_LOG);
            }
        }
        return sb.toString();
    }
}
