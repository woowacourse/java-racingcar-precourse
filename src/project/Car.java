package project;

public class Car {
    private final String name;
    private int position = 0;
    static final int moveValue=4; 
    
    public Car(String name) {
        this.name = name;
    }
    
    public void moveCar(){
        int num=getRandom();
        if(isCarMove(num)==true)
            position++;        
    }
    
    public int getRandom() {
        return (int) (Math.random() * 10);
    }
    
    public boolean isCarMove(int num){
        return num>=moveValue?true:false;
    }
    
    public void printCar(){
        System.out.print(name + " : ");
        for(int i=0;i<position;i++){
            System.out.print("-");
        }
        System.out.println();
    }
    
    public String getName(){
        return name;
    }
    
    public int getPosition(){
        return position;
    }

}
