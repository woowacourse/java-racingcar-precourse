# 자동차 경주 게임 - 프리코스 2주차
 ### 구현순서
 1. **Main class Implementation**
     * Process User input
     * Initialize variables
     * Print output
 
 2. **Car class Implementation**
    * Constructor
    * getter
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
    
    * ``` public void printMovingForward() ```
        * Method Name : movingForward 
        * Parameter  : 
            * none
        * Return :
            * none 
        * Description : Random variable 를 생성하여 4이상인 경우 위치값을 1만큼 증가시키고,
        Random variable 값이 4미만인 경우엔 현재 position 을 유지한다. 그리고 나서 출력 형식에
        맞게 Car instance 의 이름과 위치를 출력해준다.
        
    * ``` public String[] getName() ```
        * Method Name : getName
        * Parameter  : 
            * none
        * Return :
            * String name 
        * Description : Car instance 의 name 을 return 해준다.
        
    * ``` public int getPosition() ```
        * Method Name : getPosition
        * Parameter  : 
            * none
        * Return :
            * int position 
        * Description : Car instance 의 position 을 return 해준다.
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
        출력해주고 null 을 return 한다.
   
    ```
    public static Car[] initializeCar(String[] names)
    ```
    * Method Name : initializeCar
    * Parameter
        * String[] names - Car name array
    * Return
        * Car[] cars
    * Description
        
        Car instance array 를 생성하고, 사용자로 부터 입력받았던 이름들을 사용하여 instance 
        들을 생성하여 반환한다.  
        
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
          게임을 진행한다.
    
    ```
    public static void printWinner(Car[] cars, int[] movingCounter)
    ```
      * Method Name : printWinner
      * Parameter 
          * Car[] cars - Car instance array 
           
      * Return
          * none
      * Description
          
          게임의 최종 우승자를 출력해준다.
          
