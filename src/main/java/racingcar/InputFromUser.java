package racingcar;

import java.util.ArrayList;

public class InputFromUser {
    static FastReader scan = new FastReader();

    public static ArrayList<Car> inputCarName() {
        String inputText = scan.nextLine();
        String[] carNames = inputText.split(",");

        ArrayList<Car> carNameList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            // --> validation 실행 //

            carNameList.add(new Car(carNames[i]));
        }
        System.out.println(carNameList);

        return carNameList;
    }

    public static int inputNumberOfTry() {
        int numberOfTry = scan.nextInt();
        // --> validation 실행 //

        return numberOfTry;
    }
}
