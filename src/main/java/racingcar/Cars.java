package racingcar;

public class Cars implements ICars {
    private Car[] carsArray;
    private int[] carsPosition;

    @Override
    public void createCar(String[] names){
        int nameCount = names.length;
        carsArray = new Car[nameCount];
        carsPosition = new int[nameCount];
        for (int i = 0; i < nameCount; i++) {
            carsArray[i] = new Car(names[i]);
        }
    }

    @Override
    public void moveCar(){
        for (int i = 0; i < carsArray.length; i++) {
            if (carsArray[i].pickRandomNumber()) {
                carsPosition[i] ++;
            }
        }
    }

    @Override
    public void getWinner(){
        int maxPosition = getMaxPosition();
        String result = "최종 우승자 : ";
        for (int i = 0; i < carsPosition.length; i++) {
            if (carsPosition[i] == maxPosition) {
                result += carsArray[i].getName() + ", ";
            }
        }
        System.out.println(result.substring(0, result.length() - 2));
    }

    @Override
    public void printResult(int count) {
        for (int i = 0; i < carsArray.length; i++) {
            System.out.println(carsArray[i].getTrace().get(count));
        }
        System.out.println();
    }

    private int getMaxPosition() {
        int result = 0;
        for (int i = 0; i < carsPosition.length; i++) {
            result = Math.max(carsPosition[i], result);
        }
        return result;
    }
}
