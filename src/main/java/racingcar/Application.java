package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {

    public static void checkNames(String[] names){
        for (String name: names){
            if (name.length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5 이내여야 한다.");
            }
        }
    }

    public static String[] getNames(){

        while (true){
            try{
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String inputNames = Console.readLine();

                String[] names = inputNames.split(",");

                checkNames(names);

                return names;

            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름은 5 이내여야 한다.");
            }
        }
    }

    public static int checkTimes(String inputTimes){
        String patternNumberOnly = "^[0-9]*$";
        boolean regex = Pattern.matches(patternNumberOnly, inputTimes);
        int times = Integer.parseInt(inputTimes);

        if (!regex || (inputTimes.isEmpty())) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }

        return times;
    }

    public static int getTimes(){

        int times;

        while (true) {

            try{

                System.out.println("시도할 횟수는 몇회인가요?");
                String inputTimes = Console.readLine();

                times = checkTimes(inputTimes);

                return times;

            }catch(IllegalArgumentException e){
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            }

        }

    }

    public static Car[] goOneRound(String[] names, Car[] Cars){

        for (int j = 0; j < names.length; ++j){
            int random = Randoms.pickNumberInRange(1, 9);
            if (random >= 4) {
                Cars[j].increment();
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int l = 0; l < names.length; ++l){
            sb.append(names[l]).append(" : ");
            int carPosition = Cars[l].getPosition();

            for (int m = 0; m < carPosition; ++m){
                sb.append("-");
            }

            sb.append('\n');
        }

        System.out.println(sb);

        return Cars;
    }

    public static Car[] raceCars(String[] names, int times){
        Car[] Cars = new Car[names.length];

        for (int k = 0; k < names.length; ++k){
            Cars[k] = new Car(names[k]);
        }

        System.out.println("실행 결과\n");

        for (int i = 0; i < times; ++i){
            Cars = goOneRound(names, Cars);
        }

        return Cars;
    }

    public static void main(String[] args) {
        // TODO 구현 진행
        String[] names = getNames();

        int times = getTimes();

        Car[] Cars = raceCars(names, times);
    }
}
