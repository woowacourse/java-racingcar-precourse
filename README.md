# 자동차 경주 게임 - 프리코스 2주차
 ### 구현순서
 1. **Main class Implementation**
     * Process User input
     * Initialize variables
     * Print output
 2. **Car class Implementation**
    * Constructor
    * Play game
------------------------------
#### Car class
 * Variables
   * ```String name```
      * Variable name : name
      * Data type : String
      * Description : 자동차 이름을 나타낸다.
   * ```int position```
      * Variable name : position
      * Data type : int
      * Description : 자동차의 현재 위치를 나타낸다.

  * Method

    * ```booelan printMovingForward()```
        * Method Name : movingForward 
        * Parameter  : none
        * Return : boolean
        * Description : Random variable 를 생성하여 4이상인 경우 위치값을 1만큼 증가시키고, 현재
position 만큼의 출력을 해준 뒤 , true 를 return 해준다. Random variable 값이 
4미만인 경우엔 현재 position 에 맞게 출력을 해준 뒤, false 를 return 해준다.
_____
####Main class
  * Variables
    * none
  * Method
    
      ```
      public static void initializeCar(Car[] cars, String[] names,
                                                   int numberOfCars)
      ```
    * Method Name : initializeCar
    * Parameter 
        * Car[] cars - Car instance array
        * String[] names - Car name array
        * int numberOfCars - Number of car instance 
    * Return
        * none
    * Description
        
        Car instance array 에 사용자로 부터 입력받았던 이름들을 사용하여 instance
         를 생성하여 넣어준다. 
        
    ```
    public static void printGame(Car[] cars, int numberOfGames,
                                     int numberOfCars)
    ```
      * Method Name : printGame
      * Parameter 
          * Car[] cars - Car instance array
          * int numberOfGames - Number of playing game
          * int numberOfCars - Number of car instance 
      * Return
          * none
      * Description
          
          게임 플레이 횟수에 맞게 각 인스턴스 마다 printMovingForward 메소드를 반복하여
               실행시켜준다. 
          