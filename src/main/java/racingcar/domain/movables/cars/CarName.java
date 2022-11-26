package racingcar.domain.movables.cars;

public class CarName {
    private final String name;
    
    public CarName(final String name) {
        this.name = name;
    }
    
    public String name() {
        return name;
    }
    
    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
