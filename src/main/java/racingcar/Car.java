package racingcar;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameEmpty(name);
        validateNameLength(name);
        this.name = name;
    }
    
    public void moveForward(){
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" : ");
        for(int i=0;i<position;i++){
            sb.append("-");
        }
        return sb.toString();
    }

    private void validateNameLength(String name){
        if(name.length()>NAME_MAX_LENGTH){
            throw new IllegalArgumentException("[ERROR] 자동차의 이름이 5자를 초과했습니다.");
        }
    }

    private void validateNameEmpty(String name){
        if(name==null||name.isEmpty()){
            throw new IllegalArgumentException("[ERROR] 자동차의 이름이 비어있습니다.");
        }
    }
}
