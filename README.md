<h1>우아한 테크코스 프리코스</h1>
<h2>2주차 미션 - 자동차 경주 게임</h2>
<h2>제작 : 황보경(https://github.com/hwangbo)</h2>

<h3>실행 방법</h3>
<span>NumberBaseball.java에서 컴파일.</span>

<h3>기능 구현 목록</h3>
<ol>
    <li>
        RacingCar.java
        <ul>
            <li>메인 함수가 담겨있는 클래스.</li>
            <li>차의 이름과 시도할 횟수를 입력 받음.</li>
        </ul>
    </li>
    <li>
        Car.java
        <ul>
            <li>자동차 클래스가 담겨있는 클래스.</li>
            <li>자동차의 이름을 반환하는 carName 함수.</li>
            <li>자동차의 위치를 반환하는 carPosition 함수.</li>
            <li>자동차를 전진시키는 addPosition 함수.</li>
            <li>자동차의 위치를 출력하는 positionState 함수.</li>
        </ul>
    </li>
    <li>
        Game.java
        <ul>
            <li>게임을 시작하는 gameStart 함수.</li>
            <li>입력받은 자동차 이름을 ArrayList로 나눌 inputSlice 함수.</li>
            <li>자동차를 전진시키고 전진 위치를 출력하는 racingSimulation 함수.</li>
            <li>우승자를 저장하는 winnerCheck 함수.</li>
            <li>우승자를 출력해주는 winnerNotice 함수.</li>
        </ul>
    </li>
    <li>
        RandomNumber.java
        <ul>
            <li>자동차가 전진할 지 판단할 랜덤 숫자를 만드는 randomNumberCreate 함수.</li>
            <li>자동차가 전진할 지 랜덤 숫자를 확인하는 checkNumber 함수.</li>
        </ul>
    </li>
</ol>
