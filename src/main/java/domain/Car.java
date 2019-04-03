package domain;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Car {
    private final String name;
    private int position = 0;
    private static Random rand = new Random(System.currentTimeMillis());

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    public Car(String name) {
        this.name = name;
    }

    public boolean isGo(int val) {
        if(val >= 4) {
            this.position++;
            return true;
        }
        return false;
    }
    
    public static Car[] makeCar(String names) {
        String[] name = names.split(",");
        Car[] result = new Car[name.length];
        for(int i = 0; i < name.length; i++) {
            result[i] = new Car(name[i]);
        }
        return result;
    }

    public static int makeRandInt() {
        return Car.rand.nextInt(10);
    }

    public static void racing(Car car) {
        String s = "";
        car.isGo(makeRandInt());
        System.out.println(car.name + ": " + "-".repeat(car.getPosition()));
    }

    public static void winners(Car[] cars) {
        int[] distances = new int[cars.length];
        for(int i = 0; i < cars.length; i++) {
            distances[i] = cars[i].getPosition();
        }
        Arrays.sort(distances);
        String winnerIs = "";
        for(Car car : cars) {
            if(car.getPosition() == distances[distances.length - 1]){
                winnerIs += car.getName() + " ";
            }
        }

        winnerIs = winnerIs.trim().replace(" ", ", ");
        System.out.println(winnerIs + "가 최종 우승했습니다.");
    }
    public static void main(String[]args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner stdIn = new Scanner(System.in);
        String names = stdIn.nextLine();
        System.out.println("시도할 회수는 몇 회인가요?");
        int cases = stdIn.nextInt();
        Car[] cars = makeCar(names);

        System.out.println();
        while(cases-- > 0) {
            for(int i = 0; i < cars.length; i++) {
                racing(cars[i]);
            }
            System.out.println();
        }

        winners(cars);

    }

    // 추가 기능 구현
}
