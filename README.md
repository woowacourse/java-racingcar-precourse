# Racing Game

  - 간단한 자동차 경주 시뮬레이션 게임입니다.
  - 사용자는 경주할 자동차들의 이름과 시뮬레이션 횟수를 입력합니다.
  - 시뮬레이션 과정을 각 단계마다 출력합니다.
  - 시뮬레이션이 끝나면 최종 우승 자동차 목록을 출력합니다.



# 기능 요구사항

  - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다. 
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.



# 구현할 기능


  ## Car 클래스 구현

   0. 클래스 필드 정의
    - 이름
    - 위치
    - 변화값

   1. 이름 설정 및 출력
    1. 이름의 제한 사항 검사
    2. toString() 메쏘드 오버라이드
      - 이름과 위치 값을 포맷

   2. 움직임
    1. 요구사항의 범위에 맞는 랜덤 숫자 생성
    2. 전진 또는 멈춤 판단
    3. 위치값 변화값 만큼 증가 또는 유지

   3. Comparable 인터페이스 구현
     - 위치 값 기준



  ## Race 클래스 구현

   0. 클래스 필드 정의
     - Car 목록
     - 시뮬레이션 횟수: 0보다 크거나 같은 정수

   1. 시뮬레이션 횟수 설정
     - 사용자가 횟수의 유효성 검사

   2. Car 목록 입력
     - 사용자가 입력한 Car 목록 포맷의 유효성 검사

   3. 현재 경주를 상태를 출력
     - 목록에서 자동차의 이름과 위치를 결합하여 출력

   4. 경주 시뮬레이션 하나의 턴 수행
     - Car 의 움직임 메쏘드 호출
     - 매 턴 마다 Car 목록 출력

   5. 일등 Car 목록
     - Car 목록에서 위치가 최대인 Car 들을 리턴

   6. 우승 Car 목록 출력
     - 일등 Car 목록을 기준으로 포맷 및 출력

   5. 메인 메쏘드
     - Car 의 이름 목록 입력
     - 시뮬레이션 휫수 입력
     - 시뮬레이션 횟수 만큼 턴 반복
     - 우승 Car 목록 출력
