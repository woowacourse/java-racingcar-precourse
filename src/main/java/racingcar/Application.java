package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        String[] arrayCar = inputToArray();
        Car[] arrayCarObject = arrayCarObj(arrayCar);
        int Count = CountingGame();
        boolean randomGoStop = GoOrStop();
    }

    private static boolean GoOrStop() {
        boolean randomGoStop;
        int randomNum = Randoms.pickNumberInRange(0,9);
        if (randomNum >= 4) {
            randomGoStop = true;
        }
        else {
            randomGoStop = false;
        }
    }

    private static int CountingGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        String str = Console.readLine();
        int Counting = Integer.parseInt(str);
        return Counting;
    }

    private static String[] inputToArray() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCarName = Console.readLine();
        String[] arrayCar = inputCarName.split(",");
        return arrayCar;
    }

    private static Car[] arrayCarObj(String[] arrayCar) {
        Car[] arrayCarObj = new Car[arrayCar.length];
        for (int i = 0; i < arrayCar.length; i++) {
            arrayCarObj[i] = new Car(arrayCar[i]);
        }
        return arrayCarObj;
    }

}
