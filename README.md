## 구현 기능 목록

1. class Car
* tryRun 클래스 메소드 작성
  * 0~9 사이의 랜덤 숫자 생성
  * 4 이상 true, 3 이하 false 리턴
* private 변수 get/set 메소드 작성
  * getName()
  * getPosition()
  * setPosition(int)

2. 분리 메소드
* checkNameLength
  * 입력값 : String[] 입력받은 자동차 이름.split()
  * 리턴값 : boolean
  * for문으로 각각의 이름의 길이가 5 이하인지 검사
  * 길이가 모두 5 이하이면 true, 그 외 false 리턴

* showTrace
  * 입력값 : Car 자동차 인스턴스
  * 리턴값 : void
  * if문으로 자동차 인스턴스.tryRun()이면 car.position += 1
  * println String "자동차 이름 : " + Trace

* getMaxTrace
  * 입력값 : String[] traces
  * 리턴값 : int Trace 길이 최댓값
  * for 문으로 각 Trace의 길이를 구해 최댓값(MAX) 찾기

3. main 메소드
* 경주 자동차 이름 입력받기
  * String[] cars ","로 split
  * while문으로 checkNameLength 메소드가 true를 리턴할 때까지 반복
 
* 경주 자동차 인스턴스 생성
  * for문으로 각 자동차이름을 가진 Car 인스턴스 생성

* 시도 횟수 입력받기

* 경주 시작
  * println "실행결과"
  * for문 입력받은 횟수만큼 반복
  * 그 안에 for문 자동차 인스턴트 반복
  * 그 안에 각 자동차 별 showTrace 메소드 실행
  * 안쪽 for문이 다 돌면 "\n" 개행

* 우승자 발표
  * int winTraceLength = getMaxTrace 메소드로 우승 Trace 길이 구하기
  * for문으로 자동차이름Trace의 length가 최댓값과 같으면 우승자 선정
  * 선정된 우승자 ArrayList<String>.add
  * String.format() 이용, println "누구누구가 최종 우승했습니다."