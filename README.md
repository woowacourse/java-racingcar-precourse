Java-Racing Car  
==================
기능 구현 목록  
------------------
+Class CarRacingGame
>1. scanCarName - 경주할 자동차를 사용자로부터 입력받은 후, 입력된 이름들을 ","로 구분한다.
>2. isValidtext - 입력받은 자동차의 이름이 유효한지(5글자 이하인지) 확인하고, 아닐 시 재입력을 받는다.
>3. doGame - 게임을 실행한 후, 결과까지 출력한다. 이 안에 Class Car의 bringRandomNumberMovePosition과 printResult를 사용한다.
>4. printWinner - 우승자를 출력한다.  
  
+Class Car
>1. bringRandomNumberMovePosition - 0부터 9까지의 무작위의 숫자를 받은 뒤, 값의 결과에 따라 이동할지 말지를 결정한다.
>2. printResult - 이동에 따른 결과를 출력한다. 차 이름과 위치만큼 "-"로 표현된다.
>3. isMaxPosition - 우승자를 구하기 위해 최대의 값을 찾고, 비교한다.
>4. getName - 이름 출력을 위해 이름을 가져온다.
