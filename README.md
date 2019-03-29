# 자동차 경주 게임
> 메서드명과 그 역할을 미리 써보고 적절한 이름을 고민해보았다.


## Need these..

- 사용자 입력을 받는 기능
- 문자열을 "," 기준으로 잘라내는 기능
- Sequence를 순회하며 인스턴스를 생성하기
- 랜덤숫자 0~9를 생성하는 기능
- 주어진 숫자가 4보다 큰거나 같은지 판단하는 기능
- 이름과 결과를 기록할 자료구조와 그 제어.
- 숫자 n을 "-"의 n번 반복된 문자열로 바꾸는 기능
- 최대값을 찾는 기능
- 화면 출력 기능

## How To?

### 클래스

1. Car 클래스
    - 주어진 클래스  

2. RacingGame 클래스
    - 콘솔 in-out을 담당할 클래스

3. CarGroup 클래스
    - Car 인스턴스들을 제어할 클래스
    
### 좀더 자세히..

1. Car 클래스
    - Car(이름)
    - private int getRandomNumber()
        - 1~9 랜덤숫자를 생성한다.
    - private boolean isGo(int)
        - 인자값이 4보다 큰지 확인한다.
    - public void goRace()
        - getRandomNumber와 isGo를 조합한다.
    - public int getPosition()
        - 인스턴스의 포지션을 리턴한다.
    - public String getCarName()
        - Car의 name 변수를 리턴한다.

2. RacingGame 클래스
    - public void startRace()
        - 메인 메서드로부터 호출된다.
    - private String getInputConsole()
        - 콘솔 입력을 받는다.
    - private boolean isValidInput(String)
        - 인자값이 유효한지 확인한다.
    - private boolean isNumber(String)
        - 인자값을 숫자로 바꿀 수 있는지 확인한다.
    - private String invalidInputMessage()
        - 유효하지 않은 값이 전달되었음을 콘솔에 출력한다.
    - private String[] splitCarName(String)
        - ","쉼표를 기준으로 문자열을 잘라내고 잘라진 각 요소를 배열로 만들어 리턴한다.
    - private void readyCarGroup(String[])
        - 각 이름을 가진 Car 인스턴스를 갖는 CarGroup 인스턴스를 얻어온다.
    - private void printConsole(String)
        - 인자값을 콘솔에 출력한다.
    - private getResult()
        - CarGroup 인스턴스로부터 결과를 받아온다.
    - private getWinner()
        - CarGroup 인스턴스로부터 우승자를 받아온다.

3. CarGroup 클래스
    - 멤버변수중 Car[]가 있음.
    - 생성자(String[])
        - String[]에 따라 Car 인스턴스를 생성하고 Car[]에 담는다.
    - public void makeCarRace()
        - Car[]를 순회하며 getPosition()을 실행한다.
    - public String getMaxCar()
        - Car[]를 순회하며 가장 큰 position을 가진 인스턴스를 찾는다.
    - private String generateStateBar(int number)
        - 하이픈(대시)를 number 반복시킨 문자열을 얻는다.
    - public String getRaceState()
        - Car[]를 순회하며 현재 레이싱 상태를 문자열로 가져온다.
    