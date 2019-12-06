package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public int makeRandom(){
        double random_Float = Math.random() * 9; // 난수 생성
        int random_Int = (int)random_Float;
        return random_Int;
    }
    public void moveToCar(){
        int random = makeRandom();
        if(random >= 4){
            position ++;
        }else{
        }
    }
    public void progressOfCar(){
        System.out.print(this.name + ':');
        for(int progress = 0; progress < position; progress++){
            System.out.print('-');
        }
    }

}
