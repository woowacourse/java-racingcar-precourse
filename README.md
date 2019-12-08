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
    * ``` public Car(String name)```
        * Method Name : Car 
        * Parameter  : 
            * String name : 자동차 이름
        * Return : 
            * none
        * Description : 사용자로부터 입력받은 이름을 사용해서 Car 인스턴스를 생성해준다.
    
    * int printMovingForward()
        * Method Name : movingForward 
        * Parameter  : none
        * Return : int counter
        * Description : Random variable 를 생성하여 4이상인 경우 위치값을 1만큼 증가시키고, 현재
position 만큼의 출력을 해준 뒤 , 1 를 return 해준다. Random variable 값이 
4미만인 경우엔 현재 position 에 맞게 출력을 해준 뒤, 0 를 return 해준다.원래 boolean type 을 
return 해주려고 했는데, winner 를 가릴 때 counter 개념으로 사용하기 위해서 int 로 수정했다.
_____
#### Main class
  * Variables
    * none
  * Method
     ```
     public static String[] processInputText()
     ```
    * Method Name : processInputText()
    * Parameter 
        * none 
    * Return
        * String[] names : 사용자의 입력을 , 기준으로 split 하여 나눈 String array
    * Description
        
        사용자로부터 입력받은 문자열을 comma 를 기준으로 나누고, 나뉘어진 각각의 문자열의 길이가 5
        이하인지 체크해주고 맞는경우 반환해준다. 하나의 문자열의 길이가 5를 초과하는 경우 에러 메세지를 
        출력해주고 null을 return 한다.
   
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
    
    ```
    public static void printWinner(Car[] cars, int[] movingCounter)
    ```
      * Method Name : printWinner
      * Parameter 
          * Car[] cars - Car instance array
          * int[] movingCounter - 각 Car instance 가 얼마나 움직였는지를 보여주는 counter 
           
      * Return
          * none
      * Description
          
          movingCounter 를 이용해서 게임의 최종 우승자를 출력해준다.
          
