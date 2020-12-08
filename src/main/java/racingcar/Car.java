package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }


    // 異붽� 湲곕뒫 援ы쁽
    
    public void statusPrint()
    {
    	System.out.println(name);
    }
}
