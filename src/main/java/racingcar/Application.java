package racingcar;

public class Application {
    public static void main(String[] args) {
        String[] arrayCar = Input.inputToArray();
        Car[] arrayCarObject = Car.arrayCarObj(arrayCar);
        int count = Input.CountingGame();

        PlayGame(arrayCarObject, count);
        Winner.GameSet(arrayCarObject);
    }

    private static void PlayGame(Car[] arrayCarObject, int count) {
        System.out.println("실행결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arrayCarObject.length; j++) {
                Winner.PrintCarPosition(arrayCarObject[j]);
            }
            System.out.println();
        }
    }



}
