# 미션 - 자동차 경주 게임
## 기능 요구사항 
### 자동차 초기 설정
- 자동차 이름 쉼표 기준으로 사용자 입력
  - 5자 이상 이름 예외처리 :  발새
- 경주 시도할 횟수 사용자 입력
- 사용자 입력 예외 처리: `IllegalArgumentException` 발생 후 "[ERROR]" 로 시작하는 메시지 출력 
- 메시지 출력 후 재 입력 대기
### 게임 진행
- 경주 시도 횟수만큼 진행
- 0~9 난수 randomNo 생성
- randomNo >= 4 이면 전진 아닐 경우 동작 없음

### 게임 결과 
- 우승자 출력
  - 여러 명일 경우 쉼표로 구분하여 출력

### 제한 사항
- 예시와 동일하게 입출력 구현 
  - 메소드 길이 <= 15 라인 
- 메소드 한 가지 일만 하도록 구현 
- else 사용 금지 
  - if 절에서 값을 return 하는 방식 구현 
  - switch/case 금지 
  
### 출력 결과 예시 
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
## 📝 License

This project is [MIT](https://github.com/woowacourse/java-racingcar-precourse/blob/master/LICENSE) licensed.
