#Class : Car
variables
- private String name
	: name of car
- private int position
	: position of car
	
methods
- Car(String name) : constructor with car's name
- setPosition(int position) : set the position of car
- int makeRandomNumber : make the random number in range 0~9
- boolean decideGoing(int randomNumber) : decide car to go

#Class : RacingGame
variables
- pirvate List<String<ar>> carNames : array for car names
- private List<Car<ar>> cars : array for class object cars
- private int repeateCount : number of repeating race

methods
- void setCarsName() : setting the array of car names
- void setRepeateCount() : set the variable repeatCount
- String getCarName(int index) : return car name at index of 'index'
- int getCarNamesSize() : return the size of carNames
- int getRepeateCount() : return the value of repeateCount
- void makeCars() : make class car object and set the variable cars
- boolean checkNameLength : check the length of car's name
- void printCarPosition(Car car) : print the position of car
- void printCurrentCarsPosition() : print the all car's positions
