package domain;

public class RacingGame {
    User user = new User();
    UserInputChecking userinputcheck= new UserInputChecking();
    
    private Car[] car;
    private int count;
    
    Computer computer = new Computer();
    
    public void run() {
	enterCarInfo();
	for(int i=0;i<this.count;i++) {
	    createAndSetPosition();
	}
    }
    
    public void enterCarInfo() {
	String carname=user.inputCar();
	while(userinputcheck.checkCarName(carname)==false) {
	    carname=user.inputCar();
	}
	String[] tmpname = carname.split(",");
	for(int i=0;i<tmpname.length;i++) {
	    this.car[i]=new Car(tmpname[i]);
	}
	
	
	int tmpcount=userinputcheck.checkCount(user.inputCount());
	while(tmpcount!=0) {
	    tmpcount=userinputcheck.checkCount(user.inputCount());
	}
	
	this.count=tmpcount;
    }
    
    public void createAndSetPosition() {
	for(int i=0;i<car.length;i++) {
	    car[i].isGoStop(computer.createRandNum());
	}
    }
}



