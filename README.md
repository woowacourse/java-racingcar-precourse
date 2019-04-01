# 자동차 경주 게임 기능 목록

- 클래스 Car
    - `Car()` : 생성자. String name을 매개변수로 받아 Car 객체의 이름을 지정.
    - `doRacing()` : 랜덤 숫자를 생성하여, 숫자가 4 이상이면 Car 객체의 position을 1씩 증가시킴.
    - `printPosition()` : 객체의 이름과 함께 객체의 위치를 '-'으로 시각화하여 출력.
    - `getPosition()` : Car 객체의 position을 리턴.

- 클래스 RacingCar
    - `main()` : 프로그램의 진입점. RacingCar 객체를 생성하고 `play()`를 실행.
    - `play()` : 적절한 메소드를 호출하며 게임 전체를 진행시킴.
    - `setCarNames()` : 사용자 입력을 받아 Car 객체들의 이름 배열을 만들고 이를 리턴.
    - `areValidNames()` : 5자를 넘는 이름이 있는 경우 false를 리턴.
    - `makeCars()` : Car 객체들의 이름 배열을 매개변수로 받아서, Car 객체 배열의 각 원소를 초기화하고 이 객체 배열을 리턴.
    - `setNumOfGames()` : 사용자 입력을 받아 게임 횟수 지정.
    - `doGame()` : 모든 Car 객체들이 게임을 1회씩 진행하도록 하고 결과 출력. 또한 maxPosition에 position의 최댓값 저장.
    - `decideWinner()` : 우승자를 선정하고 출력.