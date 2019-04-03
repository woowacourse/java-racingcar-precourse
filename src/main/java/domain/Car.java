package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameSize(name);
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void move(int result){
        if (result == 1){
            position++;
        }
    }

    private void checkNameSize(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다." + name);
        }
    }
}
