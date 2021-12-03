## 📝 기능 명세

1. 자동차가 전진하는 기능  
0~9 사이의 랜덤값을 구하고, 무작위 값이 4 이상일 경우 전진
2. 자동차 이름을 입력하는 기능  
각 자동차의 이름은 쉼표로 구분한다.  
예외 : 이름이 5자를 초과하는 경우  
예외 : null이나 공백이 입력된 경우
3. 몇 번 이동할 것인지 입력하는 기능  
예외 : 1 보다 작은 수가 입력되는 경우
4. 우승자를 구하는 기능  
우승자는 한 명 이상, 더 많을수도 있다.
5. 에러 처리 기능 (사용자가 잘못된 값을 입력한 경우)  
IlegalArgumentException 발생  
에러 메시지 출력  
해당 부분부터 재입력
6. 각 라운드별 결과를 출력하는 기능  
   (자동차 이름) : ---
7. 우승자를 출력하는 기능  
최종 우승자 : (우승자 1), (우승자 2)

validateNames
tokenizing, 공백 삭제, 길이 확인