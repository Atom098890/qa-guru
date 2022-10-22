package guru.java;

public class First {

    public static void main(String[] args) {

        byte by = 0; // -128(2^8-1) --- 127
        short s = 1;// (2^16-1)
        int a = 5;
        long l = 1000L;
        float f = 0.8F;
        double d = 1.243;

        char c = 'A';
        String st = "Hello";

        boolean b = true;


        // + - * / %
        int result = 1 + 3;
        int result1 = 5 / 2;
        int result2 = 5 % 2;
        result += 1;

        // < > <= >= == !=
        if (2 > 1) {
            System.out.println("true");
        }

        // || && !
        boolean tr = !true;

        Person dima = new Person("Dima", 67);
        dima.goToPension();

    }
}
