package domain;


public class TryGame {
    public void start(){
        int tryCount;
        Car[] car;
        MakeCar makeCar = new MakeCar();
        TryInput tryInput = new TryInput();
        WinsCar winsCar = new WinsCar();

        car = makeCar.makingCar();
        tryCount = tryInput.tryInput();

        for(int i=0;i<tryCount;i++) {
            for (int j = 0; j < car.length; j++) {
                car[j].forwordPosition();
                System.out.print(car[j].getName()+":"+car[j].getPosition());
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(winsCar.wins(car)+"가 최종우승 하였습니다.");

    }
}
