package racingcar;

import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        String[] arrayCar = Input.inputToArray();
        Car[] arrayCarObject = Car.arrayCarObj(arrayCar);
        int count = Input.CountingGame();

        PlayGame(arrayCarObject, count);
        GameSet(arrayCarObject);
    }

    private static void PlayGame(Car[] arrayCarObject, int count) {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arrayCarObject.length; j++) {
                PrintCarPosition(arrayCarObject[j]);
            }
            System.out.println();
        }
    }

    private static void GameSet(Car[] arrayCarObject) {
        int winnerPosition = FindWinnerPosition(arrayCarObject);
        boolean flag = true;
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < arrayCarObject.length; i++) {
            int position = arrayCarObject[i].ReturnStatus();
            if (!flag && position == winnerPosition) {
                System.out.print(", ");
            }
            if (winnerPosition == position) {
                System.out.print(arrayCarObject[i].ReturnName());
                flag = false;
            }
        }
    }

    private static int FindWinnerPosition(Car[] arrayCarObject) {
        int position = 0;
        for (int i = 0; i < arrayCarObject.length; i++) {
            if (position < arrayCarObject[i].ReturnStatus()) {
                position = arrayCarObject[i].ReturnStatus();
            }
        }
        return position;
    }

    private static void PrintCarPosition(Car car) {
        car.Move(Car.GoOrStop());
        car.PrintStatus();
    }


}
