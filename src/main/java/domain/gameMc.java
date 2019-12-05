package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class gameMc {
    private String[] userInput;
    private int round = 0;
    private ArrayList<Car> carList;
    private ArrayList<Integer> scoreList;
    private Queue<String> winner;

    public String Input() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public boolean isOverFiveWords(String[] userInput) {
        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i].length() > 5) {
                return true;
            }
        }
        return false;
    }

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Input().split(",");
        while (isOverFiveWords(userInput)) {
            System.out.println("자동차 이름은 5글자 이하만 가능합니다. 다시 입력하세요.");
            userInput = Input().split(",");
        }
        System.out.println("시도할 횟수는 몇회인가요.");
        while (round == 0) {
            try {
                round = Integer.parseInt(Input());
                if (round == 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("0 이상의 숫자만 입력해주세요.");
            }
        }
    }


    public void setCarList() {
        carList = new ArrayList<Car>();
        for (int i = 0; i < userInput.length; i++) {
            carList.add(new Car(userInput[i]));
        }
    }

    public void getCarList() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).getCarName());
        }
    }


    public int generateRanNum() {
        Random ranNum = new Random();
        return ranNum.nextInt(9);
    }

    public void moveOrStay(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            if (generateRanNum() > 3) {
                carList.get(i).move();
            }
        }
    }

    public void broadcast() {
        for (int i = 0; i < carList.size(); i++) {
            // String score = '-' * position
            String score = new String(new char[carList.get(i).getPosition()]).replace('\0', '-');
            System.out.println(carList.get(i).getCarName() + " " + score);
        }
    }

    public void gameProcess() {
        for (int i = 0; i < round; i++) {
            moveOrStay(carList);
            System.out.println("----" + i + "회차----");
            broadcast();
            System.out.println("");
        }
    }


    public void scoring() {
        scoreList = new ArrayList<Integer>();
        winner = new LinkedList<String>();

        for (int i = 0; i < carList.size(); i++) {
            scoreList.add(carList.get(i).getPosition());
        }
        Integer maxScore = Collections.max(scoreList);

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPosition() == maxScore) {
                winner.add(carList.get(i).getCarName());
            }
        }
    }

    public void awarding() {
        while (winner.size() > 1) {
            System.out.print(winner.poll() + ", ");
        }
        System.out.println(winner.poll() + "가 최종 우승했습니다.");
    }
}
