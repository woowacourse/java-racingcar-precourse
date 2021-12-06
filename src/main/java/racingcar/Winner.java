package racingcar;

public class Winner {
    public static void GameSet(Car[] arrayCarObject) {
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

    public static void PrintCarPosition(Car car) {
        car.Move(Car.GoOrStop());
        car.PrintStatus();
    }
}
