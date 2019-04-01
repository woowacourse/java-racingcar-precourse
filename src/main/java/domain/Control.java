package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Control {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    ArrayList<Car> cars = new ArrayList<Car>(); // 유저로부터 입력받는 car의 이름과 위치를 저장할 변수
    int limitN = 0; // 유저로부터 입력받는 총 시도 횟수 변수

    public void userInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        setCars(carNames);
    }

    public void setCars(String str) {
        String[] carArray = str.split(",");

        for (int i = 0; i < carArray.length; i++) {
            String temp = carArray[i];
            if(temp.length() <= 5) {
                this.cars.add(new Car(temp, 0));
            }
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

    // 한 회차에서 각 자동차에 랜덤 숫자로 전진, 정지를 반영할 함수
    public void turnStart() {
        for (int i = 0; i < cars.size(); i++) {
            int ranNum = random.nextInt(10);
            Car preCar = cars.get(i);
            Car temp = (ranNum >= 4) 
                       ? new Car(preCar.getName(), preCar.getPosition() + 1) 
                       : preCar; 
            // 랜덤 숫자가 4 이상이면 해당 자동차의 포지션이 1 증가한 Car인스턴스 생성해 temp에 저장
            // 랜덤 숫자가 4 미만이면 이전 Car객체를 그대로 temp에 저장

            cars.set(i, temp);
            // 전진할지 정지할지 반영된 temp를 cars에 셋팅
        }
    }

    // 한 회차에서 각 자동차의 상태 출력 함수
    public void printTurn() {
        for (int i = 0; i < cars.size(); i++) {
            String sentence = "";
            Car temp = cars.get(i);
            sentence += temp.getName() + " : ";
            sentence += getWay(temp);
            System.out.println(sentence);
        }
    }

    // 각 자동차의 전진길이를 '-'로 리턴하는 함수
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

    // 가장 많이 움직인 횟수를 리턴하는 함수
    public int getMaxNum() {
        int maxNum = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxNum) {
                maxNum = cars.get(i).getPosition();
            }
        }
        return(maxNum);
    }

    // 가장 많은 움직임을 가진 자동차를 리턴하는 함수
    public String getGameResult(int maxNum) {
        String result = "";
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxNum) {
                result += cars.get(i).getName()+", ";
            }
        }
        return(result.substring(0, result.length()-2)+"가 최종 우승했습니다.");
    }
}