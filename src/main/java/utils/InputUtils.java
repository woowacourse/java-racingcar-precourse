package utils;

import racingcar.Car;
import racingcar.Round;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
    public static void inputNames(Scanner scanner, List<Car> cars){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = scanner.next();
        String[] name = names.split(",");
        for(int c=0; c < name.length; c++){
            cars.add(new Car(name[c]));
            if(CheckUtils.hasLongName(name[c])){
                ErrorUtils.printNameError();
                cars.clear();
                inputNames(scanner, cars);
            }
        }
    }

    public static void inputTryNumber(Scanner scanner, Round round){
        while(true){
            try{
                scanner.nextLine();
                System.out.println("시도할 횟수는 몇회인가요?");
                round.setTryNum(scanner.nextInt());
                break;
            } catch(InputMismatchException e){
                ErrorUtils.printNumError();
                continue;
            }
        }
    }




}
