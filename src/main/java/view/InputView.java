package view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class InputView {

    static final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String INPUT_TURNS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String getCarList() {
        System.out.println(INPUT_CARS_MESSAGE);
        String inputCars = readLine();
        return inputCars;

    }

    public static String getTurns() {
        System.out.println(INPUT_TURNS_MESSAGE);

        String inputTimes = readLine();
        return inputTimes;
    }

}