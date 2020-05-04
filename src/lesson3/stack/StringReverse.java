package lesson3.stack;

public class StringReverse extends StackImpl {

    public StringReverse(int maxSize) {
        super(maxSize);
    }

    public static void main(String[] args) {
        reverseStack("geekbrains");
    }

    public static void reverseStack(String str) {
        char[] array = str.toCharArray();
        StringReverse sr = new StringReverse(array.length);
        for (char ar : array) {
            sr.push(ar);
        }
        while (!(sr.size() == 0)) {
            System.out.print(sr.pop());
        }
    }
}
