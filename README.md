# 미션 - 자동차 경주 게임
우아한테크코스 프리코스 2주차 미션입니다.[원본](https://github.com/woowacourse/java-racingcar-precourse)

미션의 목표
- 함수의 분리
- 클래스의 분리

<br>

## 🚀 기능 요구사항
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

<br>

## ⭐ 구현할 기능 목록 
- Car
    - 차례 시작하기
    - 정렬 ( compareTo 오버라이드 )
    - position이 같은지 비교
    - 이름을 리턴
    - 현재 position을 리턴
- Cars
    - 생정자를 통해 Car 객체들 생성
    - 레이싱 기능 
    - 가장 빠른 자동차를 리턴     
- RacingCarGame
    - 게임 시작 기능
- InputView 
    - 자동차 이름을 입력 
    - 게임 라운드(시도)를 입력
- OutputView
    - ( 실행 결과 ) 문구 출력 
    - Car의 차례 결과를 출력
    - position을 (-) 문자열로 변경
    - 에러 로그 출력 기능
- GameRule
    - 게임 우승자를 리턴해준다.
   
<br>

## 📧 메세지 정의
기능 요구 사항을 기반으로 아래와 같은 메세지를 추론했습니다.
* 게임을 시작하라
* 게임에 필요한 데이터를 입력 받아라.
* 레이싱을 해라
* 전진 하라
* 승리자를 정해라

<br>

## 🤝 협력 설계
메세지를 기반으로 객체를 선택, 협력 구조를 아래와 같이 설계하였습니다.
![Cooperation](https://user-images.githubusercontent.com/63298320/101426258-fc16af00-393f-11eb-80e4-8b1cebf17af1.png)

<br>

## ⛔ 예외 처리
프로젝트에 사용 된 예외 목록입니다.
- IllegalArgumentException
    - RacingCarException 
        - SpaceInputException : 공백 입력 에러 
        - DelimiterInputException : 구분 기호가 엾는 압력 에러 
        - InvalidNameLengthException : 유효하지 않는 이름 에러  
        - NameDuplicationException : 중복 이름 에러 
        - InputWithoutNameException : 이름을 입력 값 에러
        - RoundIllegalArgumentException : 라운드 입력 값 에러 
      
<br> 

## 📚 참고 자료
미션의 목표처럼 요구사항에서 메세지를 분리, 객체의 협력을 구성하기 위해 참고한 자료들입니다.
* 도서
    * Clean Code - Robert C. Martin
    * 객체 지향의 사실과 오해 - 조영호
* 블로그
    * [생각하라, 객체지향처럼 - 우아한형제](https://woowabros.github.io/study/2016/07/07/think_object_oriented.html)
    
    
