package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void proceed() {
        position++;
        System.out.println(name+" : "+getBar());
    }

    private String getBar() {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar += "-";
        }
        return bar;
    }


}
