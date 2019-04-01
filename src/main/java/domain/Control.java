package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Control {
    Scanner sc = new Scanner(System.in);
    ArrayList<Car> cars = new ArrayList<Car>();
    int limitN = 0;
    Random random = new Random();

    public void userInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        setCar(carNames);
    }

    public void setCar(String str) {
        String[] carArray = str.split(",");

        for (int i = 0; i < carArray.length; i++) {
            this.cars.add(new Car(carArray[i], 0));
        }
    }

    public void userInputLimitTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        this.limitN = sc.nextInt();
    }

    public void gameStart() {
        System.out.println("실행 결과");
        int count = 0;
        while(count < limitN) {
            count ++;
            turnStart();
            printTurn();
            System.out.println();
        }
    }

    public void turnStart() {
        for (int i = 0; i < cars.size(); i++) {
            int ranNum = random.nextInt(10);
            Car preCar = cars.get(i);
            Car temp = (ranNum >= 4) 
                       ? new Car(preCar.getName(), preCar.getPosition() + 1) 
                       : preCar;
            cars.set(i, temp);
        }
    }

    public void printTurn() {
        for (int i = 0; i < cars.size(); i++) {
            String sentence = "";
            Car temp = cars.get(i);
            sentence += temp.getName() + " : ";
            sentence += getWay(temp);
            System.out.println(sentence);
        }
    }

    public String getWay(Car car) {
        String result = "";
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return(result);
    }

    public void gameEnd() {
        int maxNum = getMaxNum();
        String result = getGameResult(maxNum);
        System.out.println(result);
    }

    public int getMaxNum() {
        int maxNum = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxNum) {
                maxNum = cars.get(i).getPosition();
            }
        }
        return(maxNum);
    }

    public String getGameResult(int maxNum) {
        String result = "";
        int count = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxNum) {
                count ++;
                result += cars.get(i).getName()+", ";
            }
        }
        return(result.substring(0, result.length()-2)+"가 최종 우승했습니다.");
    }
}