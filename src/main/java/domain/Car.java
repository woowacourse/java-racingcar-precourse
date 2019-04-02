package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name)
    {
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void MakeRandomNum(){
        int RandomNum = (int)(Math.random()*10);
        if(RandomNum >=4){
            this.position++;
        }
    }

    public void ResultPositon(){
        System.out.print(this.name + " : ");

        for(int i=0; i<this.position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

}
