package domain;

import java.util.Random;

public class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
                this.name = name;
        }

        public void movePosition() {
                if(drawRandomNumber()){
                        position++;
                }

        }

        public boolean drawRandomNumber(){ //뼈대 구축
                return true;
        }

        public int getPosition(){
                return 0;
        }

        // 추가 기능 구현
}
