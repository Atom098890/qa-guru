package homework.one;

public class Car {
    String motor;
    String marka;
    String color;

    public Car(String motor, String marka, String color) {
        this.motor = motor;
        this.marka = marka;
        this.color = color;
    }

    void finishCreatedCar() {
        System.out.println("This car, have" + " motor: " + motor + " marka: " + marka + " color: " + color);
    }
}
