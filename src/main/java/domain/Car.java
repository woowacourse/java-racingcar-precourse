package domain;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void run() {
        Random random = new Random();
        int condition = random.nextInt(10);

        if (condition >= 4)
            this.position += 1;
    }

    private void outResult() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int getPosition() {
        return this.position;
    }

    private String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String names = new String();
        String name[] = new String[10];
        int count;
        ArrayList<Car> car_list = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = scan.nextLine();
        name = names.split(", ");
        System.out.println("시도할 회수는 몇회인가요?");
        count = scan.nextInt();

        for (int i = 0; i < name.length; i++)
            car_list.add(new Car(name[i]));

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < car_list.size(); k++) {
                car_list.get(k).run();
                car_list.get(k).outResult();
            }
            System.out.println();
        }

        ArrayList<String> winner = new ArrayList<>();
        int tmp = car_list.get(0).getPosition();
        winner.add(car_list.get(0).getName());
        for (int k = 1; k < car_list.size(); k++) {
            if (tmp == car_list.get(k).getPosition()) {
                winner.add(car_list.get(k).getName());
            }
            if (tmp < car_list.get(k).getPosition()) {
                winner.clear();
                winner.add(car_list.get(k).getName());
                tmp = car_list.get(k).getPosition();
            }
        }
        System.out.println(winner + "가 최종 우승했습니다");
    }
}
