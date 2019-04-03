# 구현할 기능 목록
ver 1.0.0

1. 자동차 이름을 한줄로 입력받는다.
    입력받은 이름을 split 메서드를 통해 나누어 배열에 저장한다.
    저장된 이름을 Car(String name) 생성자를 통해 각 인스턴스에 저장한다.
2. 시도할 횟수를 입력받는다.
    횟수만큼 for문을 돌린다.
3. Car 클래스에 0-9까지 랜덤값을 발생시키는 generateRandomNum 메서드 추가
    이 메서드는 전달인자는 없고, 랜덤값을 리턴함.
4. 메인메서드의 for문에서 각 단계를 실행하는 start 함수와 결과를 출력해주는
    printResult 함수를 추가.
    start 함수에서는 generateRandomNum 메서드를 실행 후 값이 4 이상이면 position을 1증가시키고
    3이하면 멈추는 기능을 구현.
    printResult 함수에서는 해당 인스턴스의 이름과 position에 따른 '-' 갯수를 출력 양식에 맞게 출력
5. decideWinner 함수를 추가한다.
    위 함수는 최종 우승을 판별하는 함수이다.
    max 변수를 선언하고 인스턴스의 getPosition 메서드를 통해 position의 최대값을 찾는다.
    printWinner 함수를 선언한다.
    위 함수의 전달인자는 car객체와 max 값이고, max과 getPosition 값이 같은 인스턴스의 이름을
    양식에 맞게 출력한다.
    
      
