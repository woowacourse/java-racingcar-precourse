package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static String carName(Car a) {                   //차 이름을 반환
        return a.name;
    }

    public static int carPosition(Car a) {                  //차 위치를 반환
        return a.position;
    }

    public static void addPosition(Car a, int forward) {    //자동차를 전진
        a.position += forward;
    }

    public static void positionState(Car a) {               //차가 얼마나 갔는지 출력
        System.out.printf("%s", a.name);
        for(int i = 0; i < a.position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

}
