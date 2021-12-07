package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    public String[] inputNames() {
        boolean isCorrect = true;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        try {
            this.verifyNames(names);
        }catch (IllegalArgumentException e) {
            isCorrect = false;
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 한다.");
        }
        while (isCorrect == false) {
            isCorrect=true;
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Console.readLine().split(",");
            try {
                this.verifyNames(names);
            }catch (IllegalArgumentException e) {
                isCorrect = false;
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야 한다.");
            }
        }
        return names;
    }

    public String inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfAttempts = Console.readLine();
        while (!this.isNumeric(numberOfAttempts)) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            System.out.println("시도할 회수는 몇회인가요?");
            numberOfAttempts = Console.readLine();
        }
        return numberOfAttempts;
    }

    public Car[] makeCars(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i=0; i< names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public void raceResult(Car[] cars, int numberOfAttempts){
        System.out.println("실행결과");
        for (int i=0; i<numberOfAttempts; i++) {
            for (int j=0; j< cars.length; j++) {
                System.out.println(cars[j].race());
            }
            System.out.println();
        }
    }

    public ArrayList<String> getWinners(Car[] cars) {
        int maxScore = 0;
        ArrayList<String> winners = new ArrayList<String>();
        for (int i=0; i<cars.length; i++) {
            if (cars[i].getPosition() == maxScore) {
                winners.add(cars[i].getName());
            }
            if (cars[i].getPosition() > maxScore) {
                maxScore = cars[i].getPosition();
                winners.clear();
                winners.add(cars[i].getName());
            }
        }
        return winners;
    }

    public void printWinners(ArrayList<String> winners) {
        String result = "최종 우승자 : "+winners.get(0);
        if (winners.size() > 1) {
            for (int i=1; i< winners.size(); i++) {
                result += ", "+winners.get(i);
            }
        }
        System.out.println(result);
    }

    public void verifyNames(String[] names) {
        for (int i=0; i<names.length; i++) {
            if (names[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        Application application = new Application();

        String[] names = application.inputNames();
        int numberOfAttempts = Integer.parseInt(application.inputNumber());
        System.out.println();

        Car[] cars = application.makeCars(names);
        application.raceResult(cars, numberOfAttempts);
        ArrayList<String> winners = application.getWinners(cars);
        application.printWinners(winners);
    }
}
