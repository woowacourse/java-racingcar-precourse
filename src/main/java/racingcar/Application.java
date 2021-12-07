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

    public static void main(String[] args) {
        // TODO 구현 진행
        String[] names = getNames();

    }
}
