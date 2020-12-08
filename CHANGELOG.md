# Change Log

이 프로젝트의 주목할만한 변화들은 모두 이곳에 기입합니다.  
작성 기준은 [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 를 따르도록 합니다.  

---
# Car Racing Game Project

## [4.0.0] (2020-12-08)

feat<RacingGamePinter>: add print racing feature

    Post update 2020-12-08 - 23:39
        - RacingGamePinter.java
        
    Add print racing feature
    
        - Car.java
        
    Add getPosition and getName feature
    
        - RandomDiceRacingGame.java
        
    It calls the print feature and toss player's cars data
     
### BREAKING CHANGE
    Finally we can see the racing

---

## [3.2.0] (2020-12-08)

feat<RandomDiceRacingGame>: add reps racing feature

    Post update 2020-12-08 - 23:33
        - RandomDiceRacingGame.java
        
    Add reps racing feature
    it repeats racing as reps times
            
---

## [3.2.0] (2020-12-08)

feat<RandomDiceRacingGame>: add random dice drive feature

    Post update 2020-12-08 - 23:30
        - RandomDiceRacingGame.java
        
    Add random dice drive feature
    it drive cars when the random number is bigger than 3
        
        - Car.java
        
    Add drive feature
    it increase it's position
            
---

## [3.1.1] (2020-12-08)

feat<GameController>: add call game start feature

    Post update 2020-12-08 - 23:25
        - GameController.java
        
    Add call game start feature
    it just calls start feature in game class
            
---

## [3.1.0] (2020-12-08)

feat<GameController>: add repeat reps input feature

    Post update 2020-12-08 - 23:23
        - GameController.java
        
    Add repeat reps input feature
    it repeats reps input feature until it get validation of input
            
---

## [3.0.0] (2020-12-08)

feat<GameController>: add repeat name input feature

    Post upload 2020-12-08 - 23:22
        - GameController.java
        
    Add repeat name input feature
    it repeats name input feature until it get validation of input
    
    Post update
        - Application.java
        
    Application creates Controller and set it up

### BREAKING CHANGE
    Now we can actually input something in this game and it prints the result
        
---

## [2.2.0] (2020-12-08)

feat<RandomDiceRacingGame>: add trying to set racing reps feature

    Post upload 2020-12-08 - 23:05
        - RandomDiceRacingGame.java
          
    Upload RandomDiceRacingGame class
        This class implements IRacingGame interface
        
        Added trying to set racing reps feature
        it validates the racing reps input and set it
        
    Post update
            - IRacingGame.java
            
        Added comments in IRacingGame interface
        
---
## [2.1.0] (2020-12-08)

feat<RacingGamePinter>: add print ready to get reps input feature

    Post update 2020-12-08 - 22:53
        - RacingGamePinter.java
        
    Add print it is ready to get reps input feature
    
---

## [2.0.0] (2020-12-08)

feat<RacingGamePlayer>: add create cars feature

    Post update 2020-12-08 - 22:50
        - RacingGamePlayer.java
        
    Add trying to create cars and answering the result feature
    
### BREAKING CHANGE
    Added create cars feature
    Now it can memorize all the car informations
        
---
## [1.2.0] (2020-12-08)

feat<RacingGamePinter>: add print wrong name input feature

    Post update 2020-12-08 - 22:43
        - RacingGamePinter.java
        
    Add print wrong name input feature
    
---

## [1.1.0] (2020-12-08)

feat<RacingGamePlayer>: add RacingGamePlayer class

    Post upload 2020-12-08 - 22:38
        - RacingGamePlayer.java
          
    Upload RacingGamePlayer class
        This class implements IRacingGamePlayer interface
        Added car name input validation feature in this project
        Now it can check the input is validate or not
        
    Post update
        - IRacingGamePlayer.java
        
    Added comments in IRacingGamePlayer interface
    
        - IRacingGamePrinter.java
        
    Fix typo in comments
        경주 상황이 담긴 값을 반환 -> 경주 상황이 담긴 값을 출력
        우승자 명단을 반환 -> 우승자 명단을 출력

---

## [1.0.0] (2020-12-08)

feat<RacingGamePinter>: add RacingGamePinter class

    Post upload 2020-12-08 - 22:23
        - RacingGamePinter.java
          
    Upload RacingGamePinter class
        This class implements IRacingGamePrinter interface
        Added print feature in this project
        Now it can print that this game is ready to get name input
        
    Post update
        - IRacingGamePinter.java
        
    Added comments in IRacingGamePrinter interface

### BREAKING CHANGE
    Added print feature
        
---

## [0.4.0] (2020-12-08)

feat<IRacingGamePinter>: Upload IRacingGamePinter interface

    Post upload 2020-12-08 - 22:06
        - IRacingGamePinter.java
          
    Upload IRacingGamePinter interface
        This interface prints all the situations in this game
---

## [0.3.0] (2020-12-08)

feat<IRacingGamePlayers>: Upload IRacingGamePlayers interface

    Post upload 2020-12-08 - 22:02
        - IRacingGamePlayers.java
          
    Upload IRacingGamePlayers interface
        This interface answers the success of cars initialization
        and returns cars and winners
---

## [0.2.0] (2020-12-08)

feat<IRacingGame>: Upload IRacingGame interface

    Post upload 2020-12-08 - 21:55
        - IRacingGame.java
          
    Upload IRacingGame interface
        This interface answers user input validations
        and setup the game itself and run it
---

## [0.1.0] (2020-12-08)

feat<IController>: Upload IController interface

    Post upload 2020-12-08 - 21:46
        - IController.java
          
    Upload IController interface
        This interface setup the game and run it with user inputs
---

## [0.0.1] (2020-12-08)

docs<README.md>: Upload coding plan

    Post upload 2020-12-08 - 21:40
        - README.md
        - CHANGELOG.md
          
    Upload coding plan and change log for Car Racing Game Project
          
          