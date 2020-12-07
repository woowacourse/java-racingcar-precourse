package View;

import racingcar.Car;

import java.util.List;

public class OutputView {
    private static final String WRITE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String WRITE_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER_IS = "최종 우승자: ";
    private static final String DELIMITER = ", ";
    private static final String COLON = " : ";
    private static final String BAR = "-";

    public static void writeTryNumber(){
        print(WRITE_TRY_NUMBER);
    }

    public static void writeCarName() {
        print(WRITE_CAR_NAME);
    }

    public static void gameResult(){
        print(GAME_RESULT);
    }

    public static void gameStatus(List<Car> cars){
        for(Car car : cars){
            print(car.getName() + COLON + bar(car.getPosition()));
        }
    }

    public static void theWinner(List<String> winners){
        print(WINNER_IS + String.join(DELIMITER, winners));
    }

    private static String bar(int position) {
        return BAR.repeat(position);
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
