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
- void race() : make car race

#Class : RacingGame

variables
- pirvate List<String<ar>> carNames : array for car names
- private List<Car<ar>> cars : array for class object cars
- private List<String<ar>> winners : names of winner in racing game
- private int repeateCount : number of repeating race


methods
- RacingGame() : default Constructor
- void setRepeateCount() : set the variable repeatCount
- void setCarsName() : setting the array of car names
- String getCarName(int index) : return car name at index of 'index'
- int getCarNamesSize() : return the size of carNames
- int getRepeateCount() : return the value of repeateCount
- void makeCars() : make class car object and set the variable cars
- int findNaxPosition() : return the max position
- void setWinningCarName() : find the winner and add the name in winners list
- void makeWinner() : find winners
- void printCarPosition(Car car) : print the position of car
- void printCurrentCarsPosition() : print the all car's positions
- void printWinner() : print the winning car names
- void raceCars() : race cars
- void run() : run the racing game

#Class : Main

- run the RacingGame class