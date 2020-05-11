package lesson5;

public class DegreeOfNumber {

    public static void main(String[] args) {

        System.out.println(degreeOfNumber(2, 0));
        System.out.println(degreeOfNumber(2, 1));
        System.out.println(degreeOfNumber(2, 5));
        System.out.println(degreeOfNumber(3, 4));
        System.out.println(degreeOfNumber(3, -4));

    }

    public static int degreeOfNumber(int number, int degree) {
        if (degree == 0)
            return 1;
        if (degree == 1)
            return number;
        if (degree < 0) {
            System.out.print("degree < ");
            return 0;
        }
        return number * (degreeOfNumber(number, degree-1));
    }
}
