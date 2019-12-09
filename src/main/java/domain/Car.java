package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
    private void printCarStatus(){
        StringBuilder output = new StringBuilder(name + ":");
        for(int i = 0; i < position; i++){
            output.append("-");
        }
        System.out.println(output);
    }

    public void moveCar(int randomInput){
        if(randomInput>3){
            position++;
        }
        this.printCarStatus();
    }
}
