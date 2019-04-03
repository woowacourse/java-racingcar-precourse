package domain;

public class Car {
        private final String name;
        private int position = 0;

        public Car(String name) {
                this.name = name;
        }

        private void printName() {
                System.out.println(this.name + " : ");
        }

        private void moveCar() {
                this.position++;
        }

        private void printPosition() {
                for (int i = 0; i<this.position;i++){
                        System.out.print("-");
                }
                System.out.println();
        }
}
