package racingcar;

import java.util.ArrayList;

public class InputFromUser {
    static FastReader scan = new FastReader();

    public static ArrayList<Car> inputCarName() {
        String inputText = scan.nextLine();
        String[] carNames = inputText.split(",");

        ArrayList<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            // --> validation 실행 //

            carList.add(new Car(carNames[i]));
        }
        System.out.println(carList);

        return carList;
    }

    public static int inputNumberOfTry() {
        int numberOfTry = scan.nextInt();
        // --> validation 실행 //

        return numberOfTry;
    }
}
