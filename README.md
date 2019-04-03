# 2주차 미션 - 자동차 경주 게임

## 기능 목록

* Car class
    - int getPosition() : 현재 position을 return. 우승자를 찾아내기 위한 메소드.
    - String getName() : 현재 name을 return.
    - void boostOrStop() : random값 기준으로 전진하거나 멈춘다.
    - String toString() : print하기 위하여 string객체로 변환시킨다. "이름 : (거리)" 형식
    - (static) boolean isNameValid() : 입력된 이름이 5자 이하인지 판별하는 메소드.
    
* Main class : 아래 method들은 전부 static임.
    - String[] getStrings() : 텍스트를 입력받아 검증하는 메소드.
        + separateString() 실행으로 분리시킴
        + Car.isNameValid() 실행으로 이름에 에러는 없는지 검증
        + 에러가 있으면 다시 반복, 에러가 없으면 String[] 반환.
    - String[] separateStrings() : 입력받은 텍스트를 컴마 기준으로 나누어 String[]으로 반환
    - boolean IsStringsValid() : 전달받은 String[]을 검사하여 유효성 검증.
    - Car[] makeCars() : String 배열을 이용해 Car를 생성한 후에 Car[]를 반환
    - Scanner getScanner() : Scanner 객체가 없다면 새로 생성, 있다면 전역변수로 있는 Scanner를 반환.
    - void race() : 시도횟수 n을 받아서 그만큼 for문을 돌림. 각 Car에 boostOrStop() 실행한다.
    - ArrayList<String> findWinner() : Car[] 중에서 getPosition()한 값이 가장 큰 것들을 모음.
    