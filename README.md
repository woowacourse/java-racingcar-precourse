# java-racingcar
> 자동차 경주 게임 미션을 위한 저장소

## 구현기능

### 1. Main class
_run racing game as Main class._
  - main()
  
### 2. Racing class
_include racing game detail info._
  - List<Car>&nbsp; &nbsp; cars
  - int&nbsp; &nbsp; movingNumber
  - run()&nbsp; : _main method in Racing class. run racing game using other methods._
  - setCar()&nbsp; : _fork car and designate name using UserInput class._
  - setMovingNumber()&nbsp; : _set moving times using UserInput class._
  - startRacing()&nbsp; : _start racing for each cars._
  - grading()&nbsp; : _grading score and print winners._
  
### 3. Car class
_include car info._
  - String&nbsp; &nbsp; name
  - int&nbsp; &nbsp; position
  - Car()&nbsp; : _constructor._
  - getName()&nbsp; : _getter._
  - getPosition()&nbsp; : _getter._
  - move()&nbsp; : _move car using Random class._
  - printCurrentPosition()&nbsp; : _print current car position._
  
### 4. UserInput class
_receive user input and verify._
  - enterCar()&nbsp; : _receive user input of car._
  - enterMovingNumber()&nbsp; : _receive user input of moving number._
  - checkFormat()&nbsp; : _verify user input format._
  - checkDuplication()&nbsp; : _verify user input duplicate._
  
### 5. Random class
_just generate random number._
  - int&nbsp; &nbsp; randomNumber
  - Random()&nbsp; : _constructor._
  - getRandomNumber()&nbsp; : _getter._
  