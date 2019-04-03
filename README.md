*class RacingGame
    *run() : 레이싱 게임의 전체적인 작동을 위한 함수
    *initCar() : Car 클래스에서 ArrayList의 형식으로 객체를 생성했을 때, 그때의 각 객체에게 자동차 이름을 부여하는 함수
    *move() : 레이싱 게임에서 각 자동차 객체가 움직이는 것을 나타내는 함수
    *getWinner() : 레이싱 게임에서 가장 많이 움직인 자동차 객체의 이름을 ArrayList로 반환하는 함수
    *showWinner() : 승리자의 이름 ArrayList를 받으면 이를 형식에 맞게 출력하는 함수
    
*class Car
    *movePos() : 랜덤 함수에 의해 자동차 객체가 이동하면 position변수의 값을 더해주는 함수
    *showPos() : 자동차 객체의 position만큼 이동한 것을 기호로 표현해주는 함수
    *getPosition() : 외부로 자동차 객체의 position을 알려주는 함수
    *getName() : 외부로 자동차 객체의 name을 알려주는 함수