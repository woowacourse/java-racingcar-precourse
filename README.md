## 2주차 미션 - 자동차 경주 게임

## 프로그램 설명
1. 주어진 횟수동안 n대의 자동차는 전진, 정지할 수 있습니다.

2. 이동 횟수는 사용자의 입력으로 정해집니다.

3. 0부터 9사이의 random 수를 구해 3이하의 수는 자동차를 정지시키고, 4이상의 수는 자동차를 전진시킵니다.

4. 게임이 완료된 후 우승자를 출력하며, 우승자는 한 명 이상일 수 있습니다.

## 구현 기능 목록
1. 사용자로부터 경주할 자동차의 이름을 입력받는 기능. 
   (예외처리 - 이름 길이가 5자를 넘을 경우) 

2. 사용자로부터 자동차를 이동시킬 횟수를 입력받는 기능. 
    (예외처리 - 숫자가 아닌 문자가 입력되었을 경우)

3. 게임에 참가하는 자동차의 리스트를 만드는 기능.

4. random 수를 구하고 반환하는 기능.

5. 반환된 random 수에 따라서 자동차를 전진, 정지시키는 기능.

6. 우승자를 출력하는 기능.

7. 게임을 실행시키는 기능.

## 클래스와 주요 메소드 설명
1 . Application.java
 : 게임을 실행시키는 클래스.
 
2 . Car.java
 : 자동차의 정보를 나타내는 클래스.
 - moveCar() : Car객체의 position의 값을 증가시키는 메소드.
 
3 . CarGame.java
 : 게임을 진행하는 클래스.
 + createRacingCarList(String[] racingCarNameList) : 게임에 참가하는 자동차의 이름을 파라미터로 받아서 Car객체 리스트를 생성해 반환하는 메소드.
 + playGame() : 게임을 진행하는 메소드.
 + goOrNotCar(Car car) : Random 값을 구하고, 그 수에 따라서 자동차를 전진, 정지시키는 메소드.
 + printCarPosition(Car car) : 현재 Car객체의 position을 출력하는 메소드.
 + getCarsMaxPosition() : 게임에 참가한 자동차들 중에서 가장 큰 position을 반환하는 메소드.
 + getWinner() : 게임의 승자를 구한 후, 승자의 이름을 리스트 객체에 넣고 반환하는 메소드.
 + printWinner(List<String> winnerList) : 승자의 이름이 담긴 리스트 객체를 파라미터로 받아서 출력하는 메소드. 

4 . UserInput.java
 : 사용자의 입력을 받는 클래스.
 + getRacingCarName() : 사용자에게 게임에 참가하는 자동차의 이름을 입력받고, 이름이 담긴 배열을 반환하는 메소드.
 + checkCarNameList(String[] carNameList) : 사용자가 조건(자동차 이름이 5자 이하)에 맞게 자동차 이름을 입력했는지 확인하고 확인 결과에 따라서 boolean값을 반환하는 메소드.
 + getTryCount() : 사용자에게 게임의 시도 횟수를 입력받고, 횟수를 리턴하는 메소드.
 + checkTryCount(String count) : 사용자가 조건(숫자만 입력)에 맞게 시도 횟수를 입력했는지 확인하고 확인 결과에 따라서 boolean값을 반환하는 메소드.
 
5 . RandomNumber.java
 : random 수를 구하고 반환하는 클래스.
 + getRandomNumber() : Random객체를 이용해서 0~9까지의 random 수를 구하고, 구한 수를 반환하는 메소드.