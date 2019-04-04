# java-racingcar
Car Racing Game을 하기 위한 클래스와 필드, 메소드 등을 구현하는 프로젝트

## 기능목록
**1. Car 클래스**: 레이싱 게임을 하는 주체인 Car를 생성하고 기능을 정의
<ul>
<li>게임에 필요한 필드 및 getter</li>
<li>name을 활용한 생성자 </li>
<li>Car가 전진할지 말지를 결정하는 move 메소드</li>
<li>참가한 Car들의 전진 결과를 '-'을 통해 시각화하는 showMoveProgress 메소드</li>
</ul>

**2. RacingGame 클래스**: 게임을 진행
<ul>
<li>게임을 실질적으로 진행하기 위한 필드</li>
<li>게임의 일련의 과정이 실행되는 main 메소드</li>
<li>게임에 참가할 Car들을 생성하는 makeRacingCars 메소드</li>
<li>참가한 Car들이 race를 하는 race 메소드</li>
</ul>

**3. Announcer 클래스**: 게임의 중간 결과를 알려주고 최종 우승자를 발표
<ul>
<li>게임에 참가한 Car들의 전진 결과를 나타내는 showRaceProgress 메소드</li>
<li>1명 이상의 최종 우승자를 말해주는 tellWinner 메소드</li>
<li>최종 우승자의 position을 가져오는 findMaxPosition 메소드</li>
</ul>