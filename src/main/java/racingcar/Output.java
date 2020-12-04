package racingcar;

public class Output {
    private static final String GO_MARK = "-";
    
    private Car[] car;
    
    public Output(Car[] car) {
        this.car = car;
    }
    
    public void printResult(){
        for (int i = 0; i < car.length; i++) {
            String carName = car[i].getName();
            int carPosition = car[i].getPosition();
            System.out.print(carName + " : ");
            for (int j = 0; j < carPosition; j++) {
                System.out.print(GO_MARK);
            }
            System.out.println();
        }
    }
}