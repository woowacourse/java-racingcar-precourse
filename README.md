# 프로젝트 개요
![racingcar](https://user-images.githubusercontent.com/35681772/70409433-1ef15780-1a8f-11ea-97c5-ffa856ef5ab0.gif)
 - 자동차 경주를 시뮬레이션한 게임이다.
 - 자동차의 이름은 5자 이하만 가능하며, 쉼표로 구분된다.
 - 입력받은 시행 회수만큼 레이싱을 한다.

# 기능 목록
 - 게임을 시작하면 사용자에게 자동차 이름과 시행에 대한 입력을 받는다.
 - 받은 입력을 트랙에 넘겨 경주에 필요한 준비를 한다.
 - 자동차는 입력받은 이름의 길이가 5이하인 경우 name에 할당한다.
 - 자동차는 입력받은 이름의 길이가 5를 초과하는 경우 예외를 발생시킨다.
 - 자동차는 random number의 값이 4 이상일 경우, position의 값을 1 증가시킨다.
 - 자동차는 random number의 값이 4 미만일 경우, 움직이지 않는다.
 - 트랙은 입력받은 시행이 숫자일 경우 trial에 할당한다.
 - 트랙은 입력받은 시행이 숫자가 아닐 경우 예외를 던진다.
 - 트랙은 입력받은 자동차 이름들을 가지고 자동차를 준비시킨다.
 - 트랙에서는 입력받은 시행 회수만큼 race를 한다.
 - 트랙은 경주중인 자동차의 상태를 출력한다.
 - 트랙은 winner를 리턴한다.
 - 게임의 최중 우승자를 출력한다.