baemin HW2 자동차 경주 게임
==========================
---
기능 설명
--------
---
### class Car


+ ` private final String name; ` *자동차의 이름* 저장

+ ` private int position; ` *자동차의 위치* 저장

+ ` public Car(String name){} ` *자동차의 이름* 변수로 받아 *초기화* 시켜주는 생성자

+ ` public String getName(){} ` *자동차의 이름* *return* 해주는 함수

+ ` public int getPosition(){} ` *자동차의 위치* *return* 해주는 함수

+ ` public void goOrStop(){} ` 1~9 까지 랜덤 숫자를 받아 4이상이면 자동차는 앞으로 가고 아니면 정지해있는다. *둘중 하나의 상태(Go or Stop)를 위치에 적용*한 뒤 *위치를 이름과 함께 출력*해준다.

### class main


+ ` String[] cars; ` *자동차들을 저장* 해놓은 배열이다.

+ ` int racingTime; ` *몇번의 레이싱*을 할것인지 저장 해놓은 변수

+ ` public static String[] getCarName(){} ` 자동차의 이름을 입력받아 *','* 를 기준으로 *나눠서 String 배열에 저장 후 return* 해준다

+ ` public static int getRacingTime(){} ` *몇번의 레이싱을 할것인지 입력받아 return* 해준다

+ ` public static Car[] setCars(String[] name){} ` 자동차의 이름들을 입력 받아 *숫자에 맞게 동적 생성해서 이름을 초기화* 한 후 *자동차 배열 return* 한다. 

+ ` public static void racing(Car[] cars, int time){} ` 실질적으로 자동차들이 레이싱을 진행하는 부분이다. *어떤 자동차들이 몇번의 레이싱을 진행할 것인지* 파라미터로 입력받아 *레이싱을 진행한다*.

+ ` public static void printWinners(Cars[] car){} ` 자동차 배열을 입력받아 레이싱이 끝날때 까지 얼마나 이동했는지 *모든 자동차의 위치(position)*을 비교하여 *가장 먼 위치(position)*에 있는 자동차들을 우승자로 출력한다. 
