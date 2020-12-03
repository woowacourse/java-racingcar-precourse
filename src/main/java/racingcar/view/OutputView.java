package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RACE_START_LOG = "실행 결과";
    private static final String WINNER_LOG_BEGIN = "최종 우승자: ";
    private static final String AND_LOG = ", ";

    public static void printRaceStartLog(){
        System.out.println(RACE_START_LOG);
    }

    public static void printRaceProgressLog(List<Car> carList){
        for(Car car : carList){
            System.out.println(car.toString());
        }
    }

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
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    private static String getWinnerLog(List<Car> winners){
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_LOG_BEGIN);
        concatWinners(winners, sb);
        return sb.toString();
    }

    private static void concatWinners(List<Car> winners, StringBuilder sb){
        for(int i = 0; i < winners.size(); i++){
            sb.append(winners.get(i).getName());
            if(i != winners.size() -1){
                sb.append(AND_LOG);
            }
        }
    }
}
